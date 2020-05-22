public class TestDialog {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setBounds(0, 0, 500, 500);
                frame.setVisible(true);

                JDialog dialog = new JDialog(frame);
                dialog.setModal(true);
                JPanel panel = new JPanel();
                dialog.add(panel);
                final JTextArea area = new JTextArea();
                panel.add(area);
                dialog.setBounds(100, 100, 200, 200);
                area.setLineWrap(true);
                area.setText("bbbbbbbbbbbb");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                System.out.println("Hello");
                                area.setText("zzzz");
                            }
                        });
                    }
                }).start();

                dialog.setVisible(true);
            }
        });
    }
}