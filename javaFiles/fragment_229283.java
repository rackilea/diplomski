import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;


public class LineDraw extends JFrame {

    private JPanel contentPane;
    JScrollPane scrollPane = new JScrollPane();
    JPanel panel = new JPanel(){
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawLine(btnNewButton.getLocation().x,btnNewButton.getLocation().y, btnNewButton_1.getLocation().x,btnNewButton_1.getLocation().y);
        }

    };
    JButton btnNewButton = new JButton("New button");
    JButton btnNewButton_1 = new JButton("New button");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LineDraw frame = new LineDraw();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LineDraw() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane.setBounds(0, 0, 424, 251);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(panel);
        panel.setLayout(null);

        btnNewButton.setBounds(27, 98, 89, 23);
        panel.add(btnNewButton);

        btnNewButton_1.setBounds(213, 137, 89, 23);
        panel.add(btnNewButton_1);
        initListener();
    }

    private void initListener()
    {
        btnNewButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                super.mouseDragged(me);
                Point pos = panel.getMousePosition();
                System.out.println(pos);
                if(panel.getWidth()-pos.x<50 && panel.getHeight()-pos.y<50)
                {
                    panel.setPreferredSize(new Dimension(panel.getWidth()+50,panel.getHeight()+50));
                }
                else if(panel.getHeight()-pos.y<50)
                {
                    panel.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()+50));
                }
                else if(panel.getWidth()-pos.x<50)
                {
                    panel.setPreferredSize(new Dimension(panel.getWidth()+50,panel.getHeight()));
                }
                btnNewButton.setLocation(pos);
                validate();
                repaint();
            }
        });
        btnNewButton_1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                super.mouseDragged(me);
                Point pos = panel.getMousePosition();
                if(panel.getWidth()-pos.x<50 && panel.getHeight()-pos.y<50)
                {
                    panel.setPreferredSize(new Dimension(panel.getWidth()+50,panel.getHeight()+50));
                }
                else if(panel.getHeight()-pos.y<50)
                {
                    panel.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()+50));
                }
                else if(panel.getWidth()-pos.x<50)
                {
                    panel.setPreferredSize(new Dimension(panel.getWidth()+50,panel.getHeight()));
                }
                btnNewButton_1.setLocation(panel.getMousePosition());
                validate();
                repaint();
            }
        });
    }

}