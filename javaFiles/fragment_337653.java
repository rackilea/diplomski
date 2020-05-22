JDialog loadingScreen = new JDialog((JFrame) null);
JLabel loaded = new JLabel();
loadingScreen.add(loaded);
loading.add(time);
loading.setSize(new Dimension(200,100));

Thread t = new Thread(() -> {
    loading.setVisible(true);
    while (i3 < Math.pow(characters.size(), Integer.parseInt(length.getText()))) {
        SwingUtilities.invokeLater(() -> time.setText(i3 + " / " + 
            Math.pow(characters.size(), Integer.parseInt(length.getText()))));
        System.out.println("hi");
    }
});
...
t.start();