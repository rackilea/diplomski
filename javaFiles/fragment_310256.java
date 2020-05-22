String[] paths = {"C:/1.jpg", "C:/2.jpg", "C:/3.jpg", "C:/4.jpg", "C:/5.jpg", "C:/6.jpg", "C:/7.jpg", "C:/8.jpg"};
for(int i = 0; i < 8; i++) {
    ImageIcon image = new ImageIcon(paths[i]);
    JButton button = new JButton(image);
    buttonList.add(button);
}