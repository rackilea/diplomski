public class Message {

    // Private constructor to prevent external instantiation
    private Message(){
    }

    public static void createAndShowDialog(final String content, final int time){
        final JDialog dialog = new JDialog();
        dialog.setLayout(new BorderLayout());
        dialog.setUndecorated(true);

        JLabel label = new JLabel(content);
        label.setFont(new Font("Monospaced", Font.BOLD, 20));

        Box b = Box.createHorizontalBox();
        b.add(Box.createHorizontalGlue());
        b.add(label, BorderLayout.CENTER);
        b.add(Box.createHorizontalGlue());

        dialog.add(b);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // kick-off timer
        Timer t = new Timer(time, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              dialog.dispose();
            }
        });
        t.setRepeats(false);
        t.start();
    }
}