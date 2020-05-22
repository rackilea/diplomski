import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;

    private TreeDrawer treeDrawer;

    public Main() {

        setTitle("Tree");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);

        treeDrawer = new TreeDrawer();
        add(treeDrawer, BorderLayout.CENTER);
        getContentPane().setBackground(Color.BLACK);

        //button shit
        JButton generate = new JButton("Generate");
        generate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                treeDrawer.generate();
                repaint();
            }
        });

        add(generate, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main();
        });

    }

    public class TreeDrawer extends JComponent {

        private static final long serialVersionUID = 1L;

        public static final int ROOM_WIDTH = 1080;
        public static final int ROOM_HEIGHT = 720 - 47;// 47 is the height of menu bar on top of jframe or some shit
        double len = 100;

        public TreeDrawer() {
            setPreferredSize(new Dimension(ROOM_WIDTH, ROOM_HEIGHT));
        }

        private String axiom = "F";
        private String sentence = axiom;

        private String rules(char a) {
            if (a == 'F')//a rule
            {
                return "FF+[+F-F-F]-[-F+F+F]";
            }
            return "";//if nothing else works, shit
        }

        //probably correct
        public void generate() {
            len *= 0.5;//shrink the shit
            String nextSentence = "";
            for (int i = 0; i < sentence.length(); i++) {
                char current = sentence.charAt(i);
                nextSentence += rules(current);
            }
            sentence = nextSentence;
            System.out.println(sentence);
//            turtle();
        }

        public void turtle(Graphics2D graphics) {

            AffineTransform transform = null;//so you can save shit

            for (int i = 0; i < sentence.length(); i++) {
                char current = sentence.charAt(i);

                if (current == 'F') {//draw up
                    graphics.drawLine(0, 0, 0, (int) -len);
                    graphics.translate(0, -len);
                } else if (current == '+') {//right turn
                    graphics.rotate(Math.PI / 6);
                } else if (current == '-') {//left turn
                    graphics.rotate(-Math.PI / 6);
                } //probably wrong shit
                else if (current == '[') {//save transformations

                    transform = graphics.getTransform();
                } //also probably wrong shit
                else if (current == ']') {//restore from last save
                    graphics.setTransform(transform);
                }
            }
        }

        @Override
        public void paintComponent(Graphics g) {//so that shit is drawn
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paintComponent(g2d);
            g2d.translate(ROOM_WIDTH / 2, ROOM_HEIGHT - 10);
            g2d.setPaint(Color.WHITE);

            turtle(g2d);
            g2d.dispose();
        }
    }

}