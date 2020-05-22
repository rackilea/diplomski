public static void ChangImage(String pathe) {
    frame.getContentPane().removeAll();
    frame.getContentPane().add(new MapFrame(pathe));
    label.revalidate();
    frame.setVisible(true);
}