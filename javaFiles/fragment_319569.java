import java.awt.Color;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;

    import javax.swing.JButton;

    /**
     * Customized <code>JButton</code> to obtained a feedback user experience of movement.
     * @author Gabriel Moreno.
     */
    public class FeedbackTouchScreenButton extends JButton {

        public FeedbackTouchScreenButton() {
            super();

            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(final MouseEvent e) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Color bg = e.getComponent().getBackground();
                                e.getComponent().setBackground(Color.BLUE); // For example
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                                e.getComponent().setBackground(bg);
                            }
                        }).start();
                } // mouseClicked()

                @Override
                public void mouseEntered(MouseEvent e) {}
                @Override
                public void mouseExited(MouseEvent e) {}
                @Override
                public void mousePressed(MouseEvent e) {}
                @Override
                public void mouseReleased(MouseEvent e) {}
            });
        } // FeedbackTouchScreenButton()

    } // FeedbackTouchScreenButton