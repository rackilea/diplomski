import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class SimplePlaybackProgress
extends WindowAdapter implements Runnable, ActionListener {
    class AudioPlayer extends Thread {
        volatile boolean shouldPlay = true;
        final int bufferSize;

        final AudioFormat fmt;

        final AudioInputStream audioIn;
        final SourceDataLine audioOut;

        final long frameSize;
        final long totalFrames;
        final double sampleRate;

        AudioPlayer(File file)
                throws UnsupportedAudioFileException,
                       IOException,
                       LineUnavailableException {

            audioIn     = AudioSystem.getAudioInputStream(file);
            fmt         = audioIn.getFormat();
            bufferSize  = fmt.getFrameSize() * 8192;
            frameSize   = fmt.getFrameSize();
            totalFrames = audioIn.getFrameLength();
            sampleRate  = fmt.getSampleRate();
            try {
                audioOut = AudioSystem.getSourceDataLine(audioIn.getFormat());
                audioOut.open(fmt, bufferSize);
            } catch (LineUnavailableException x) {
                try {
                    audioIn.close();
                } catch(IOException suppressed) {
                    // Java 7+
                    // x.addSuppressed(suppressed);
                }
                throw x;
            }
        }

        @Override
        public void run() {
            final byte[] buffer = new byte[bufferSize];
            long framePosition = 0;

            try {
                audioOut.start();

                while (shouldPlay) {
                    int bytesRead = audioIn.read(buffer);
                    if (bytesRead < 0) {
                        break;
                    }

                    int bytesWritten = audioOut.write(buffer, 0, bytesRead);
                    if (bytesWritten != bytesRead) {
                        // shouldn't happen
                        throw new RuntimeException(String.format(
                            "read: %d, wrote: %d", bytesWritten, bytesRead));
                    }

                    framePosition += bytesRead / frameSize;
                    // or
                    // framePosition = audioOut.getLongFramePosition();
                    updateProgressBar(framePosition);
                }

                audioOut.drain();
                audioOut.stop();
            } catch (Throwable x) {
                showErrorMessage(x);
            } finally {
                updateProgressBar(0);

                try {
                    audioIn.close();
                } catch (IOException x) {
                    showErrorMessage(x);
                }

                audioOut.close();
            }
        }

        void updateProgressBar(
                final long framePosition) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    double fractionalProgress =
                        (double) framePosition / (double) totalFrames;
                    int progressValue = (int) Math.round(
                        fractionalProgress * theProgressBar.getMaximum());

                    theProgressBar.setValue(progressValue);

                    int secondsElapsed = (int) Math.round(
                        (double) framePosition / sampleRate);
                    int minutes = secondsElapsed / 60;
                    int seconds = secondsElapsed % 60;

                    theProgressBar.setString(String.format(
                        "%d:%02d", minutes, seconds));
                }
            });
        }

        void stopPlaybackAndDrain() throws InterruptedException {
            shouldPlay = false;
            this.join();
        }
    }

    /* * */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SimplePlaybackProgress());
    }

    JFrame theFrame;
    JButton theButton;
    JProgressBar theProgressBar;

    // this should only ever have 1 thing in it...
    // multithreaded code with poor behavior just bugs me,
    // even for improbable cases, so the queue makes it more robust
    final Queue<AudioPlayer> thePlayerQueue = new ArrayDeque<AudioPlayer>();

    @Override
    public void run() {
        theFrame = new JFrame("Playback Progress");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        theButton = new JButton("Open");
        theProgressBar = new JProgressBar(
            SwingConstants.HORIZONTAL, 0, 1000);
        theProgressBar.setStringPainted(true);
        theProgressBar.setString("0:00");

        Container contentPane = theFrame.getContentPane();
        ((JPanel) contentPane).setBorder(
            BorderFactory.createEmptyBorder(8, 8, 8, 8));
        contentPane.add(theButton, BorderLayout.WEST);
        contentPane.add(theProgressBar, BorderLayout.CENTER);

        theFrame.pack();
        theFrame.setResizable(false);
        theFrame.setLocationRelativeTo(null);
        theFrame.setVisible(true);

        theButton.addActionListener(this);
        theFrame.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JFileChooser dialog = new JFileChooser();
        int option = dialog.showOpenDialog(theFrame);

        if (option == JFileChooser.APPROVE_OPTION) {
            File file = dialog.getSelectedFile();
            try {
                enqueueNewPlayer(new AudioPlayer(file));
            } catch (UnsupportedAudioFileException x) { // ew, Java 6
                showErrorMessage(x);                    //
            } catch (IOException x) {                   //
                showErrorMessage(x);                    //
            } catch (LineUnavailableException x) {      //
                showErrorMessage(x);                    //
            }                                           //
        }
    }

    @Override
    public void windowClosing(WindowEvent we) {
        stopEverything();
    }

    void enqueueNewPlayer(final AudioPlayer newPlayer) {
        // stopPlaybackAndDrain calls join
        // so we want to do it off the EDT
        new Thread() {
            @Override
            public void run() {
                synchronized (thePlayerQueue) {
                    stopEverything();
                    newPlayer.start();
                    thePlayerQueue.add(newPlayer);
                }
            }
        }.start();
    }

    void stopEverything() {
        synchronized (thePlayerQueue) {
            while (!thePlayerQueue.isEmpty()) {
                try {
                    thePlayerQueue.remove().stopPlaybackAndDrain();
                } catch (InterruptedException x) {
                    // shouldn't happen
                    showErrorMessage(x);
                }
            }
        }
    }

    void showErrorMessage(Throwable x) {
        x.printStackTrace(System.out);
        String errorMsg = String.format(
            "%s:%n\"%s\"", x.getClass().getSimpleName(), x.getMessage());
        JOptionPane.showMessageDialog(theFrame, errorMsg);
    }
}