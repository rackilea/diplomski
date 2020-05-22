public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        final JFrame f = new JFrame("test");
        final JButton b = new JButton("Hello");
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(b, BorderLayout.NORTH);
        f.setSize(300, 200);
        f.setVisible(true);
        b.addActionListener((e) -> {
            JDialog dialog = new JDialog(f);
            dialog.getContentPane().add(new JLabel(new Date().toString()));
            dialog.pack();
            Point point = b.getLocationOnScreen();
            //dialog.setLocationRelativeTo(b); // Shows over button, as doc says
            dialog.setLocation(new Point(point.x, point.y + b.getHeight()));
            dialog.setVisible(true);
        });
    });
}