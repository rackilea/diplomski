while (ifFinished == false) {

    Color color = myRobot.getPixelColor(912, 487);   // <==== move inside loop

    System.out.println("Red color of pixel   = " + color.getRed());
    System.out.println("Green color of pixel = " + color.getGreen());
    System.out.println("Blue color of pixel  = " + color.getBlue());

    //Checks if color is white
    if (color.getRed() == 255 && color.getGreen() == 255
            && color.getBlue() == 255) {
        ifFinished = true;  //if it is set ifFinished to true
        System.out.println("stuck in while->if");
    } else
        Thread.sleep(1000);
    ifFinished = false;
    System.out.println("stuck in while->else");
    System.out.println(ifFinished);
}