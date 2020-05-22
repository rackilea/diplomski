JButton easterButt = new JButton("Pass CSE 116");
//JLabel eastLbl = new JLabel();
//added button to JLabel
//eastLbl.add(easterButt);
try {
    String path = "/GUI/MatthewPhoto.jpg";
    eastImg = new ImageIcon(ImageIO.read(this.getClass().getResource(path)));

} catch (Exception ex) {
    System.out.print(ex);
}
//added label to Panel
dropDownPanel.add(easterButt);
easterButt.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        easterButt.setIcon(eastImg);
    }
});