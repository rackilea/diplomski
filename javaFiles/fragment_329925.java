public class OpenCVTest {

    public static void main(String[] args) {
        OpenCV.loadLibrary();

        Mat m = Highgui.imread("/home/artur/Pictures/test.png", Highgui.CV_LOAD_IMAGE_GRAYSCALE);
        LoadImage( m);
        Mat res = Mat.zeros(m.size(), m.type());
        Imgproc.adaptiveThreshold(m, res, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 15, 20);
        LoadImage(res);
        Mat cannyRes = Mat.zeros(m.size(), m.type());
        Imgproc.Canny(res, cannyRes, 55, 5.2);
        LoadImage(cannyRes);

        Imgproc.dilate(cannyRes, cannyRes, new Mat(), new Point(-1, -1), 2);
        Imgproc.erode(cannyRes, cannyRes, new Mat(), new Point(-1, -1), 2);

        LoadImage(cannyRes);

        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(cannyRes, contours, new Mat(), Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);

        System.err.println(contours.size());

        contours = contours.stream().filter(s -> s.size().area() > 50 && s.size().area() <= 100).collect(Collectors.toList());

        for(MatOfPoint p : contours) {
            Size size = p.size();
            System.err.println("-- -- --");
            System.err.println(size.area());
        }

        Imgproc.drawContours(cannyRes, contours, 20, new Scalar(233, 223,212));
        LoadImage(cannyRes);
    }

    public static void LoadImage( Mat m) {
        Path path = Paths.get("/tmp/", UUID.randomUUID().toString() + ".png");
        Highgui.imwrite(path.toString(), m);
        JFrame frame = new JFrame("My GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        // Inserts the image icon
        ImageIcon image = new ImageIcon(path.toString());
        frame.setSize(image.getIconWidth() + 10, image.getIconHeight() + 35);
        // Draw the Image data into the BufferedImage
        JLabel label1 = new JLabel(" ", image, JLabel.CENTER);
        frame.getContentPane().add(label1);

        frame.validate();
        frame.setVisible(true);
    }

}