import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SimpleJFrameProgram extends JFrame {
     private static final long serialVersionUID = 1L;

     public SimpleJFrameProgram() {
         super("TEST");

         initComponents();

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.pack();
         this.setLocationRelativeTo(null);
         this.setVisible(true);
     }


    private void initComponents() {
        MemoryPanel memoryPanel = new MemoryPanel();

        this.add(memoryPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SimpleJFrameProgram();
                } catch (Exception e) {
                   e.printStackTrace();
                }
            }
       });
    }
 }