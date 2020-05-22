// Load the image
    Mat image_orig = imread(inputFile);
    if ( image_orig.empty() ) { LOGGER.error("Empty image!");}

    this.image = new Mat();
    //Add a border to the image for processing sake
    copyMakeBorder(image_orig, this.image, 50, 50, 50, 50, BORDER_CONSTANT);

    //# Calculate the width and height of the image

    this.img_y = this.image.arrayHeight();
    this.img_x = this.image.arrayWidth();

    if (DEBUG)
        LOGGER.info("Image is " + this.img_x + "x" + this.img_x);

    //Split out each channel
    Mat red = new Mat();
    Mat green = new Mat();
    Mat blue = new Mat();

    MatVector v = new MatVector(red, green, blue);
    split(image, v);

    //Run canny edge detection on each channel
    Mat blue_edges = new Mat();
    Canny(v.get(0), blue_edges, 200, 250);
    Mat green_edges = new Mat();
    Canny(v.get(1), green_edges, 200, 250);
    Mat red_edges = new Mat();
    Canny(v.get(2), red_edges, 200, 250);

    //Join edges back into image
    Mat edges = new Mat();
    MatVector vEdges = new MatVector(red_edges, green_edges, blue_edges);
    merge(vEdges, edges);
    LOGGER.info("Type: " + edges.type());


    //convert to grayscale
    Mat gray = new Mat();
    cvtColor(edges, gray, COLOR_BGR2GRAY);
    Mat blur = new Mat();
    GaussianBlur(gray, blur, new Size(5,5), 0);
    Mat edgesCopy = new Mat();
    adaptiveThreshold(blur, edgesCopy, 255,1,1,11,2);


    //Find the contours        
    Mat hierarchy = new Mat();
    MatVector contours = new MatVector();

    findContours(edgesCopy, contours, hierarchy, RETR_TREE, CHAIN_APPROX_NONE);