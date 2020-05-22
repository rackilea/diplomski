// ** Below code if for reference purposes only, consult OpenCV docs for proper API methods
int character_area_lower_thresh = 10;
for (Contour c:contours) {
     if (Imgproc.contourArea(c) > character_area_lower_thresh) {
         // Desired contour, do what ever you want to do
         Rect r = Imgproc.boundingRect(c);
     }
}