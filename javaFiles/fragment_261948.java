import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;

@SuppressWarnings("serial")
public class RedirectOut extends JPanel {
   private static final int BUTTON_COUNT = 4;
   private JTextArea textArea = new JTextArea(20, 20);
   private SomeAgent myAgent;

   public RedirectOut() {
      redirectSystemStreams();

      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

      for (int i = 0; i < BUTTON_COUNT; i++) {
         final int count = i + 1;
         JButton button = new JButton(new AbstractAction("Send Message " + count){
            @Override
            public void actionPerformed(ActionEvent e) {
               myAgent.setStep(String.valueOf(count));
               System.out.println("Button Pressed => STEP = "
                     + myAgent.getStep());
               myAgent.behaSend();
            }
         });
         JPanel btnPanel = new JPanel();
         btnPanel.add(button);
         add(btnPanel);
      }
      add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
   }

   public void setAgent(SomeAgent agent) {
      this.myAgent = agent;
   }

   public void updateTextArea(final String text) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            textArea.append(text);
         }
      });
   }

   private void redirectSystemStreams() {
      OutputStream out = new OutputStream() {
         @Override
         public void write(int b) throws IOException {
            updateTextArea(String.valueOf((char) b));
         }

         @Override
         public void write(byte[] b, int off, int len) throws IOException {
            updateTextArea(new String(b, off, len));
         }

         @Override
         public void write(byte[] b) throws IOException {
            write(b, 0, b.length);
         }
      };

      System.setOut(new PrintStream(out, true));
      System.setErr(new PrintStream(out, true));
   }

   private static void createAndShowGui() {
      RedirectOut redirectOut = new RedirectOut();
      redirectOut.setAgent(new SomeAgent());

      JFrame frame = new JFrame("RedirectOut");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(redirectOut);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}