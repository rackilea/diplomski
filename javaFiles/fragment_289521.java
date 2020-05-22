List<Mat> src = new ArrayList<>();

Mat image = Highgui.imread("faces/s1/1.pgm", 0);
src.add(image);

image = Highgui.imread("faces/s1/2.pgm", 0);
src.add(image);

image = Highgui.imread("faces/s1/3.pgm", 0);
src.add(image);

image = Highgui.imread("faces/s1/4.pgm", 0);
src.add(image); 

image = Highgui.imread("faces/s2/1.pgm", 0);
src.add(image);

image = Highgui.imread("faces/s2/2.pgm", 0);
src.add(image);

image = Highgui.imread("faces/s2/3.pgm", 0);
src.add(image);

image = Highgui.imread("faces/s2/4.pgm", 0);
src.add(image);   

Mat labels = new Mat(8, 1, CvType.CV_32SC1);
labels.put(0, 0, 1);
labels.put(1, 0, 1);
labels.put(2, 0, 1);
labels.put(3, 0, 1);
labels.put(4, 0, 2);
labels.put(5, 0, 2);
labels.put(6, 0, 2);
labels.put(7, 0, 2);

FaceRecognizer recognizer = new LBPHFaceRecognizer();
recognizer.train(src, labels);