int countF = 0;
for(int i = 0; i < listofItems.size(); i++) {
    try {
        // all your stuff here
        // ...

        // this will create an image with new name each time
        ImageIO.write(saveImage, "jpg", new File(countF + ".jpg"));
        countF++;
    } catch (IOException e) {
        e.printStackTrace();
    }
}