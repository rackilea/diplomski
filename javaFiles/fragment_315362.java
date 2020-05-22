try 
{
        imageToDisplay = Toolkit.getDefaultToolkit().createImage(Base64.decode(myString));
} catch (Exception e1) {
        //          // TODO Auto-generated catch block
        e1.printStackTrace();
}

ImageIcon logoIcon = new ImageIcon(imageToDisplay);
JLabel logolabel = new JLabel(logoIcon);
mainPanel.add(logolabel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
    GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, 
    new Insets(2, 2, 2, 2), 0, 0));