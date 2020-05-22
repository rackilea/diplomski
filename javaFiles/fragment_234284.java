public void loadImage()
   {
     try
     {
     img=ImageIO.read(this.getClass().getResource(Constant.kurukafa));
     }
     catch(IOException e)
     {
     e.printStackTrace();
     } 
   }