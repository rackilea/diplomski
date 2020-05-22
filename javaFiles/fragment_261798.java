/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

import java.io.FileNotFoundException;
import java.io.IOException;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.beans.*;

public class ProgressBarDemo extends JPanel
                             implements ActionListener, 
                                        PropertyChangeListener {

  private JProgressBar overallProgressBar;
  private JProgressBar currentProgressBar;
  private JButton startButton;
  private JTextArea taskOutput;
  private Task task;

  class Task extends SwingWorker<Void, Integer> {

    private final JProgressBar currentProgressBar;

    private Task(JProgressBar progressBar) {
      currentProgressBar = progressBar;
    }

    private void download(String urlString, int fileNumber, int total) {
      java.io.InputStream in = null;
      java.io.OutputStream out = null;

      try {
        taskOutput.append("Downloading file " + fileNumber + "...");

        java.net.URL url = new java.net.URL(urlString);

        java.net.HttpURLConnection httpConnection = (java.net.HttpURLConnection) (url.openConnection());

        long completeFileSize = httpConnection.getContentLength();
        in = httpConnection.getInputStream();
        out = new java.io.FileOutputStream("picture"+fileNumber+".png");

        final byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int count;
        while ((count = in.read(data, 0, 1024)) != -1) { 
          // --------------------------
          // TODO: Make downloads slower so you can watch things better, do not use in production code!
          try {
            Thread.sleep(200);
          } catch (InterruptedException ignore) {}
          // --------------------------

          downloadedFileSize += count;

          /* calculate progress (cheap variant, we assume that files are roughly the same size), another, more proper, way would be to prefetch all file sizes and give actual progress */
          final int currentProgress = (int) (((double)downloadedFileSize) / ((double)completeFileSize) * 100d );
          final int scaledCurrentProgress = currentProgress / total;
          final int overallProgress = (int) (((double)fileNumber/(double)total) * 100d);
          /* notifications of progress */
          setProgress(Math.min(scaledCurrentProgress + overallProgress,100));
          publish(Math.min(currentProgress,100));
          /* save downloaded data */        
          out.write(data, 0, count);
        } 

        taskOutput.append("done!\n");           
      } catch (FileNotFoundException e) {
        taskOutput.append("File not found: " + e);
      } catch (IOException e) {
        taskOutput.append("IO exception: " + e);
      } catch (Exception e) {
        taskOutput.append("Something went wrong: " + e);
      } finally {
        try {
          if (in != null) {
            in.close();
          }
          if (out != null) {
            out.close();
          }
        } catch (IOException e) {
          taskOutput.append("IO exception: " + e);
        }
      }
    }

    /*
     * Main task. Executed in background thread.
     */
    @Override
    public Void doInBackground() {
      // TODO: Probably this data would be given to the class in the constructor
      java.util.List<String> urlStrings = java.util.Arrays.asList(
                                            "http://imgs.xkcd.com/comics/tamagotchi_hive.png ", 
                                            "http://imgs.xkcd.com/comics/solar_system_questions.png ",
                                            "http://imgs.xkcd.com/comics/90s_kid.png",
                                            "http://imgs.xkcd.com/comics/xkcd_phone_3.png",
                                            "http://imgs.xkcd.com/comics/episode_vii.png");

      setProgress(0);

      int numberOfURLs = urlStrings.size();

      for (int i = 0; i < numberOfURLs; i++) {
        download(urlStrings.get(i), i, numberOfURLs);
      }

      return null;
    }

    /*
     * Handle data from publish(), i.e., current file progress
     */
    @Override
    protected void process(java.util.List<Integer> progressList) {
      final int progress = progressList.get(progressList.size() - 1);
      currentProgressBar.setValue(progress);
    }

    /*
     * Executed in event dispatching thread
     */
    @Override
    public void done() {
      setCursor(null); //turn off the wait cursor
      taskOutput.append("All files downloaded!\n");
    }
  } // end of class Task

  public ProgressBarDemo() {
    super(new BorderLayout());

    //Create the demo's UI.
    startButton = new JButton("Start");
    startButton.setActionCommand("start");
    startButton.addActionListener(this);

    overallProgressBar = new JProgressBar(0, 100);
    overallProgressBar.setValue(0);
    overallProgressBar.setStringPainted(true);

    currentProgressBar = new JProgressBar(0, 100);
    currentProgressBar.setValue(0);
    currentProgressBar.setStringPainted(true);

    taskOutput = new JTextArea(5, 20);
    taskOutput.setMargin(new Insets(5,5,5,5));
    taskOutput.setEditable(false);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3,2));
    panel.add(new JLabel("Current File"));
    panel.add(currentProgressBar);
    panel.add(new JLabel("Overall Progress"));
    panel.add(overallProgressBar);
    panel.add(startButton);

    add(panel, BorderLayout.PAGE_START);
    add(new JScrollPane(taskOutput), BorderLayout.CENTER);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  }

  /**
   * Invoked when the user presses the start button.
   */
  public void actionPerformed(ActionEvent evt) {
    startButton.setEnabled(false);
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    //Instances of javax.swing.SwingWorker are not reusuable, so
    //we create new instances as needed.
    task = new Task(currentProgressBar);
    task.addPropertyChangeListener(this);
    task.execute();
  }

  /**
   * Invoked when task's progress property changes.
   */
  public void propertyChange(PropertyChangeEvent evt) {
    if ("progress" == evt.getPropertyName()) {
      int progress = (Integer) evt.getNewValue();
      overallProgressBar.setValue(progress);
    } 
  }

  /**
   * Create the GUI and show it. As with all GUI code, this must run
   * on the event-dispatching thread.
   */
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame frame = new JFrame("ProgressBarDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Create and set up the content pane.
    JComponent newContentPane = new ProgressBarDemo();
    newContentPane.setOpaque(true); //content panes must be opaque
    frame.setContentPane(newContentPane);

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}