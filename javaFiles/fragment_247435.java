/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaintquestions;

/**
 *
 * @author peter
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestPanel extends javax.swing.JPanel {

    public boolean draw = true;

    public TestPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 603, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 299, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (draw == true) {
            // g.drawLine(0, 0, 20, 35);
        }
        paintSmile(g, draw);
    }

    public void change() {
        draw = !draw;

        this.repaint();

    }

    public void paintSmile(Graphics g, boolean smile) {

        g.setColor(Color.black);

        g.fillRect(0, 0, 400, 400);

        g.setColor(Color.yellow);

        g.fillOval(0, 0, 400, 400);

        g.setColor(Color.black);

        g.fillOval(100, 100, 50, 50);

        g.fillOval(250, 100, 50, 50);

        g.drawArc(150, 250, 100, 100, 180, 180);

        if (smile) {
            g.drawArc(150, 250, 100, 100, 180, 180);
        } else {
            g.drawArc(150, 250, 100, 100, 0, 180);
        }

      //  repaint();
    }

    public static void main(String[] args) {

        TestPanel panel = new TestPanel();

        JButton button = new JButton();
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                panel.change();
            }

        };

        button.addActionListener(al);

        JFrame frame = new JFrame();

        frame.add(panel);
        frame.add(button);

        frame.setVisible(true);
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(800, 800);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}