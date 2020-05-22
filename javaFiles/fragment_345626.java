public class FaceDetect {

   // Create memory for calculations
   CvMemStorage storage = null;

   // Create a new Haar classifier
   CvHaarClassifierCascade classifier = null;

   // List of classifiers
   String[] classifierName = {
                "./classifiers/haarcascade_frontalface_alt.xml",
                "./classifiers/haarcascade_frontalface_alt2.xml",
                "./classifiers/haarcascade_profileface.xml" };

   public FaceDetect() {
        // Allocate the memory storage
        storage = CvMemStorage.create();

        // Load the HaarClassifierCascade
        classifier = new CvHaarClassifierCascade(cvLoad(classifierName[0]));

        // Make sure the cascade is loaded
        if (classifier.isNull()) {
                System.err.println("Error loading classifier file");
        }
   }

   public boolean find (Image value ){
        // Clear the memory storage which was used before
        cvClearMemStorage(storage);

        if(!classifier.isNull()){
                // Detect the objects and store them in the sequence
                CvSeq faces = cvHaarDetectObjects(value.getImage(), classifier,
                                storage, 1.1, 3, CV_HAAR_DO_CANNY_PRUNING);

                // Get the number of faces found.
                int total = faces.total();
                if (total > 0) {
                    return true;
                }
        }
        return false;
   }
}