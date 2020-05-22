// ...
ClassLoader loader = Thread.currentThread().getContextClassLoader();
String xmlResource = loader.getResource("opencv/haarcascade_frontalface_alt.xml").getPath();
File file = new File(xmlResource);
xmlResource = file.getAbsolutePath());
// ...
CascadeClassifier faceDetector = new CascadeClassifier(xmlResource);
if(faceDetector.empty()){
    ErrorUtils.println("cascade classifier is empty");
    return false;
}
// ...