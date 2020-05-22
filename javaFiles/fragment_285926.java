if (isDalvik()) {
  Find_Faces_Android ff = new Find_Faces_Android();   
  ff.readImage(this.getClass().getResourceAsStream("test.jpg"));
  int no_detected_faces = ff.findFaces( 1, 40, new File("result.jpg"));
} else {
  Find_Faces_JVM ff = new Find_Faces_JVM();
  ff.readImage(this.getClass().getResourceAsStream("test.jpg"));
  int no_detected_faces = ff.findFaces( 1, 40, new File("result.jpg"));
}