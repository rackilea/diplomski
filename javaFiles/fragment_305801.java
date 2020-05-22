InputStream inputStream = null ;
        try {
        inputStream = new FileInputStream(new File("fileName"));
        } catch (FileNotFoundException e2) {
            logger.error("File not found ");
        }

        IContainerFormat format = IContainerFormat.make();
        format.setInputFormat("flv");


        container1 = IContainer.make();


        if (container1.open( inputStream , format) < 0) {
            throw new IllegalArgumentException("could not open file: " + fileName);
        }