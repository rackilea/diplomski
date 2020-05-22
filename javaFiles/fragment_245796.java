fileLoad = chooser2.getSelectedFile();
try 
{
      img2 = ImageIO.read(fileLoad);
      panel.setImage(img2);
} 
catch (IOException e1) 
{
   e1.printStackTrace();
}