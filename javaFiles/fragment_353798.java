try {
    // AS-IS
    //image = ImageIO.read(new File("//RandomThingsInGui/whiteFish.png"));

    // TO-BE (replace '//' to '/')
    image = ImageIO.read(new File("/RandomThingsInGui/whiteFish.png"));
} catch (IOException e) { 
    e.printStackTrace();
}