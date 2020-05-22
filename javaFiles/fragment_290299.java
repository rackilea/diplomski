ImageIcon photo1 = new ImageIcon("foto1.jpg");
ImageIcon photo2 = new ImageIcon("foto2.jpg");
ImageIcon photo3 = new ImageIcon("foto3.jpg");
ImageIcon photo4 = new ImageIcon("foto4.jpg");
ImageIcon photo1copy = new ImageIcon("foto1.jpg");
ImageIcon photo2copy = new ImageIcon("foto2.jpg");
ImageIcon photo3copy = new ImageIcon("foto3.jpg");
ImageIcon photo4copy = new ImageIcon("foto4.jpg");

Map<JButton, ImageIcon> buttonImage = new HashMap<JButton, ImageIcon>();

public MemoriinFrame() {
      setTitle("Memory Game");
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      setLayout(new GridLayout(2, 4));

      for(int i = 0; i <= 7; i++) {

          button[i] = new JButton();
          button[i].setIcon(tail);
          button[i].addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  performActionEventHandler((JButton)e.getSource());
              }
          });
          add(button[i]);
      }

      addIcons();

}

public void performActionEventHandler(JButton clickedButton) {
    clickedButton.setIcon(buttonImage.get(clickedButton));
}

public void addIcons() {
    icons.add(photo1);
    icons.add(photo2);
    icons.add(photo3);
    icons.add(photo4);
    icons.add(photo1copy);
    icons.add(photo2copy);
    icons.add(photo3copy);
    icons.add(photo4copy);
    Collections.shuffle(icons);

    for(int i=0;i<icons.size();i++){
        buttonImage.put(button[i], icons.get(i));
    }
}