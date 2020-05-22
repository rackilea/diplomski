Mat image = imread("images/Text00.png", CV_8UC1);

    // Make sure it was successfully loaded.
    if (image == null) {
        System.out.println("Image not found!");
        System.exit(1);
    }

    UByteBufferIndexer sI = image.createIndexer();

    for (int y = 0; y < image.rows(); y++) {

        for (int x = 0; x < image.cols(); x++) {

            System.out.println( sI.get(y, x) );
        }
    }