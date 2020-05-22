try {
        Robot       robot   = new Robot();
        Dimension   scrSize = Toolkit.getDefaultToolkit().getScreenSize();

        //Create the image 
        BufferedImage exportImage = robot.createScreenCapture(new Rectangle(0, 0, (int) scrSize.getWidth(), (int) scrSize.getHeight()));

        //Get graphics - Get the layer we can actually draw on
        Graphics2D imageGraphics = (Graphics2D) exportImage.getGraphics();

        //Cleanup after ourselves
        imageGraphics.dispose();

        screenShotName          = generateUniqueValue().retStringValue + ".png";
        String[] pathSections   = GlobalVars.getInstance().getLogDir().split("\\\\");
        pathSections[pathSections.length-1] = "";

        String path = "";
        for (int x = 0; x < pathSections.length-1; x++) {
            path = path + pathSections[x] + "\\";
        }