private void drawRock(int i,int j){
      //i and j are the cols and row values so you need to resolve them to coordinates.
      //I am assuming u have a 800*600 screen and you mentioned that your world is 100x100 array. Then each of your object is 8*6 units in size so
     xCoord=i*8;
     yCoord=j*6; 
        //So if you have to draw a rock on [10][15] it will resolve as
        //xCoord=10*8-> 80
        //yCoord=15*6-> 90  so it will draw your rock in (80,90) on the screen

//Now you can either open the rock image from your disk now or u maintain one instance of rock at the beginning of the program so that you can use the same image later rather than opening it everytime you encounter a new Rock object in your array.For now I will open it here.

   String path = "C:\\YourGameDirectory\\rock.jpg";
    URL url = new File(path).toURI().toURL();
    BufferedImage rockImg = ImageIO.read(url);

   //draw it to the screen now if you have the graphics instance.
    yourUIPanel.getGraphics().drawImage(rockImg,xCoord,yCoord,yourUIPanel);

  // You may find many resources that teach you how to draw an image on the screen in         Java. You may repeat the same for all the objects.

 }