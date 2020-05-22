try
 {
     URL url2 = new URL (textField.getText());
     lblNewLabel.setIcon(new ImageIcon(ImageIO.read(url2)));
 }
 catch (Exception e)
 {

 }