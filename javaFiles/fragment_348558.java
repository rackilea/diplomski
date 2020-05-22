for (File file : files) {
    try {
        ...
        HistogramPanel panel = new HistogramPanel(width, counts, height, horizon);
        JDialog dialog = new JDialog();
        dialog.setModal(false);        <---- very important
        dialog.setLayout(new BorderLayout());
        dialog.add(panel);
        dialog.pack();
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);
    } catch (...)
}