import java.awt.BorderLayout;
  import java.awt.Color;
  import java.awt.Dimension;
  import java.awt.Graphics;
  import java.awt.Graphics2D;

  import javax.swing.JPanel;

  public class MemoryPanel extends JPanel {

    public MemoryPanel(){
         setPreferredSize(new Dimension(350,448));
    }

    @Override
    public void paintComponent(Graphics g) {
        // POSITIONING
        setLayout(new BorderLayout());

        // CREATE MEMORY BUTTONS
        MemoryButton a = new MemoryButton();

        // Drawing Rectangles for Memory
        add(a,BorderLayout.CENTER);

    }

    private class MemoryButton extends JPanel{
        public MemoryButton(){
            setLayout(null);
            setPreferredSize(new Dimension(87,40));
        }

        @Override
        public void paintComponent(Graphics g) {

            Graphics2D td = (Graphics2D) g;
            td.setColor(Color.red);
            td.fillRect(0, 0, 20, 20);
        }
    }
 }