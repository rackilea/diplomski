import java.awt.*;
import javax.swing.*;
import javax.sound.sampled.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SoundMixer {

    public Component getGui() {
        JPanel gui = new JPanel(new GridLayout(0,1));

        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        System.out.println(
                "There are " + mixers.length + " mixer info objects");
        for (Mixer.Info mixerInfo : mixers) {
            System.out.println("mixer name: " + mixerInfo.getName());
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info[] lineInfos = mixer.getSourceLineInfo();
            for (Line.Info lineInfo : lineInfos) {
                System.out.println("  Line.Info: " + lineInfo);
                try {
                    Line line = mixer.getLine(lineInfo);
                    FloatControl volCtrl = (FloatControl)line.getControl(
                            FloatControl.Type.MASTER_GAIN);
                    VolumeSlider vs = new VolumeSlider(volCtrl);
                    gui.add( new JLabel(volCtrl.toString()) );
                    gui.add( vs.getVolume() );
                    System.out.println(
                            "    volCtrl.getValue() = " + volCtrl.getValue());
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException iaEx) {
                    System.out.println("    " + iaEx);
                }
            }
        }

        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                SoundMixer sm = new SoundMixer();
                Component c = sm.getGui();
                JOptionPane.showMessageDialog(null, c);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }
}

class VolumeSlider {

    JSlider volume;

    VolumeSlider(final FloatControl volumeControl) {
        volume = new JSlider(
                (int) volumeControl.getMinimum() * 100,
                (int) volumeControl.getMaximum() * 100,
                (int) volumeControl.getValue() * 100);
        ChangeListener listener = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                float val = volume.getValue() / 100f;
                volumeControl.setValue(val);
                System.out.println(
                        "Setting volume of " + volumeControl.toString() + 
                        " to " + val);
            }
        };
        volume.addChangeListener(listener);
    }

    public JSlider getVolume() {
        return volume;
    }
}