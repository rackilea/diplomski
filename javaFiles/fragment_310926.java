Container gContentPane = frame.getContentPane();
JScrollPane scroll = new JScrollPane(gContentPane);
frame.setContentPane( scroll );
frame.revalidate();
frame.repaint();

if (scroll != null) {
    frame.setContentPane(gContentPane);
    frame.revalidate();
    frame.repaint();
}