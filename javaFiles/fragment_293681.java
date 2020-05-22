import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PopUpMessage {

    private int height = 0;
    private Rectangle screenRect = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getMaximumWindowBounds();
    private JPanel panel = new JPanel();
    private JLabel text;
    private JLabel messageSMS;
    private String messageFull;
    private static JTextArea textArea = new JTextArea();
    final JButton plus = new JButton("Plus");
    final JButton reply = new JButton("Reply");
    final JButton close = new JButton("Exit");
    final JButton send = new JButton("Send");
    private int secondClick = 0;
    private static JScrollPane scrollPaneTextArea = new JScrollPane(textArea);
    private Dimension panelDimension = new Dimension(300, 100);
    private JDialog dialog = new JDialog() {

        /**
     * 
     */
        private static final long serialVersionUID = 1L;

        @Override
        public void paint(Graphics g) {
            g.setClip(0, 0, getWidth(), height);
            super.paint(g);
        }
    };

    private Timer timer = new Timer(1, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            height += 5;
            if (height == dialog.getHeight()) {
                timer.stop();
            }
            dialog.setLocation(screenRect.width - dialog.getWidth(),
                    screenRect.height - height);
            dialog.repaint();
        }
    });

    private Timer timer2 = new Timer(1, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            height -= 5;
            if (height == 0) {
                timer.stop();
                dialog.dispose();
            }
            dialog.setLocation(screenRect.width - dialog.getWidth(),
                    screenRect.height - height);
            dialog.repaint();
        }
    });

    public void makeUI(String number, String message) {
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setUndecorated(true);
        dialog.setBackground(new Color(1, 0, 0, 0));
        panel.setPreferredSize(panelDimension);
        panel.setBackground(new Color(22, 83, 206, 200));
        panel.setLayout(null);
        dialog.setContentPane(panel);

        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timer2.setInitialDelay(0);
                timer2.start();
            }
        });
        close.setBounds(210, 70, 90, 25);

        reply.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondClick == 0) {
                    textArea.setColumns(20);
                    textArea.setLineWrap(true);
                    textArea.setRows(5);
                    textArea.setWrapStyleWord(true);
                    scrollPaneTextArea.setBounds((panel.getWidth()-280)/2, messageSMS.getY()+messageSMS.getHeight(), 280, 90);
                    panel.add(scrollPaneTextArea);
                    height = dialog.getHeight() + scrollPaneTextArea.getHeight();
                    panel.setPreferredSize(new Dimension(panel.getWidth(),
                            panel.getHeight() + scrollPaneTextArea.getHeight()));
                    dialog.setLocation(dialog.getX(), dialog.getY() - scrollPaneTextArea.getHeight());
                    plus.setBounds(plus.getX(), plus.getY()+scrollPaneTextArea.getHeight(), plus.getWidth(), plus.getHeight());
                    close.setBounds(close.getX(), close.getY()+scrollPaneTextArea.getHeight(), close.getWidth(), close.getHeight());
                    send.setBounds(0, close.getY(), close.getWidth(), close.getHeight());
                    panel.remove(reply);
                    panel.add(send);
                    dialog.pack();
                }
            }
        });
        reply.setBounds(0, 70, 90, 25);

        plus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondClick == 0) {
                    FontMetrics fm = panel.getFontMetrics(messageSMS.getFont());
                    int sizeMessage = fm.stringWidth(messageSMS.getText());
                    int decallage = (sizeMessage / 90) * 15;
                    height = dialog.getHeight() + decallage - fm.getHeight()*3;
                    panel.setPreferredSize(new Dimension(panel.getWidth(),
                            panel.getHeight() + decallage - fm.getHeight()*3));
                    messageSMS.setText("<html><P ALIGN=\"JUSTIFY\">"
                            + messageFull);
                    dialog.setLocation(dialog.getX(), dialog.getY() - decallage
                            + fm.getHeight()*3);
                    close.setBounds(close.getX(), close.getY() + decallage - fm.getHeight()*3, close.getWidth(), close.getHeight());
                    send.setBounds(send.getX(), send.getY() + decallage - fm.getHeight()*3, send.getWidth(), send.getHeight());

                    reply.setBounds(reply.getX(), reply.getY() + decallage - fm.getHeight()*3, reply.getWidth(), reply.getHeight());
                    panel.remove(plus);
                    scrollPaneTextArea.setBounds(scrollPaneTextArea.getX(), scrollPaneTextArea.getY()+ decallage - fm.getHeight()*3, scrollPaneTextArea.getWidth(), scrollPaneTextArea.getHeight());
                    messageSMS.setBounds(messageSMS.getX(), messageSMS.getY(), messageSMS.getWidth(), decallage);
                    dialog.pack();
                }
            }
        });
        plus.setBounds(105, 70, 90, 25);

        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                timer2.setInitialDelay(0);
                timer2.start();
            }
        });

        messageFull = message;
        text = new JLabel("New message from :  " + number);
        FontMetrics fm = panel.getFontMetrics(text.getFont());
        messageSMS = new JLabel("<html><center>" + message + "</center></html>");
        int textSize = fm.stringWidth(text.getText());

        text.setBounds((panelDimension.width - textSize) / 2, 0, textSize, 25);

        textSize = fm.stringWidth(messageSMS.getText());
        if (textSize > 810) {
            textSize = 290;
        }
        messageSMS.setBounds((panelDimension.width - textSize) / 2, 20,
                textSize, fm.getHeight()*3);

        panel.add(close);
        panel.add(reply);
        if (fm.stringWidth(messageSMS.getText()) > 870) {
            int sizeChar = fm.stringWidth(messageSMS.getText())
                    / messageSMS.getText().length();
            int allowedChar = 870 / sizeChar;
            String temp = message.substring(0, allowedChar - 33) + "...";
            messageSMS.setText("<html><center>" + temp + "</center></html>");
            panel.add(plus);
        }
        panel.add(messageSMS);
        panel.add(text);

        dialog.pack();
        dialog.setVisible(true);
        timer.setInitialDelay(0);
        timer.start();
    }
}