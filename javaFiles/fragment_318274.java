//loop through all test images and display
    int xAxis = 1;
    int yAxis = 1;
    for(int i = 0; i < images.length; i++)
    {
        imageHandler.displayAnImage(images[i], jvis, xAxis, yAxis, "");

        //if third image in the row then take a new line
        if(i % 3 == 0)
        {
            yAxis = yAxis + 300;
        }

        //display each image side by side
        xAxis = xAxis + 300;
    }