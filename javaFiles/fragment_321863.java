/**
 * Detects face(s) and then for each detects and crops mouth
 * 
 * @param filename path to file on which smile(s) will be detected
 * @return List of Mat objects with cropped mouth pictures.
 */
private ArrayList<Mat> detectMouth(String filename) {
    int i = 0;
    ArrayList<Mat> mouths = new ArrayList<Mat>();
    // reading image in grayscale from the given path
    image = Highgui.imread(filename, Highgui.CV_LOAD_IMAGE_GRAYSCALE);
    MatOfRect faceDetections = new MatOfRect();
    // detecting face(s) on given image and saving them to MatofRect object
    faceDetector.detectMultiScale(image, faceDetections);
    System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
    MatOfRect mouthDetections = new MatOfRect();
    // detecting mouth(s) on given image and saving them to MatOfRect object
    mouthDetector.detectMultiScale(image, mouthDetections);
    System.out.println(String.format("Detected %s mouths", mouthDetections.toArray().length));
    for (Rect face : faceDetections.toArray()) {
        Mat outFace = image.submat(face);
        // saving cropped face to picture
        Highgui.imwrite("face" + i + ".png", outFace);
        for (Rect mouth : mouthDetections.toArray()) {
            // trying to find right mouth
            // if the mouth is in the lower 2/5 of the face
            // and the lower edge of mouth is above of the face
            // and the horizontal center of the mouth is the enter of the face
            if (mouth.y > face.y + face.height * 3 / 5 && mouth.y + mouth.height < face.y + face.height
                    && Math.abs((mouth.x + mouth.width / 2)) - (face.x + face.width / 2) < face.width / 10) {
                Mat outMouth = image.submat(mouth);
                // resizing mouth to the unified size of trainSize
                Imgproc.resize(outMouth, outMouth, trainSize);
                mouths.add(outMouth);
                // saving mouth to picture 
                Highgui.imwrite("mouth" + i + ".png", outMouth);
                i++;
            }
        }
    }
    return mouths;
}