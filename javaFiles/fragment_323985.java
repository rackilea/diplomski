public class ImageWarp {
    private double x1, y1, x2, y2, x3, y3, x4, y4, X1, Y1, X2, Y2, X3, Y3, X4,
            Y4;

    public BufferedImage getCropedImage(BufferedImage imgBuffer,
            ArrayList<Coordinate> cornersCordinate, int imageWidth,
            int imageHeight) throws IOException {

        X1 = Math.abs(cornersCordinate.get(0).getX());
        Y1 = Math.abs(cornersCordinate.get(0).getY());
        X2 = Math.abs(cornersCordinate.get(1).getX());
        Y2 = Math.abs(cornersCordinate.get(1).getY());
        X3 = Math.abs(cornersCordinate.get(2).getX());
        Y3 = Math.abs(cornersCordinate.get(2).getY());
        X4 = Math.abs(cornersCordinate.get(3).getX());
        Y4 = Math.abs(cornersCordinate.get(3).getY());
        x1 = 0;
        y1 = 0;
        x2 = imageWidth - 1;
        y2 = 0;
        x3 = imageWidth - 1;
        y3 = imageHeight - 1;
        x4 = 0;
        y4 = imageHeight - 1;

        double M_a[][] = { { x1, y1, 1, 0, 0, 0, -x1 * X1, -y1 * X1 },
                { x2, y2, 1, 0, 0, 0, -x2 * X2, -y2 * X2 },
                { x3, y3, 1, 0, 0, 0, -x3 * X3, -y3 * X3 },
                { x4, y4, 1, 0, 0, 0, -x4 * X4, -y4 * X4 },
                { 0, 0, 0, x1, y1, 1, -x1 * Y1, -y1 * Y1 },
                { 0, 0, 0, x2, y2, 1, -x2 * Y2, -y2 * Y2 },
                { 0, 0, 0, x3, y3, 1, -x3 * Y3, -y3 * Y3 },
                { 0, 0, 0, x4, y4, 1, -x4 * Y4, -y4 * Y4 }, };

        double M_b[][] = { { X1 }, { X2 }, { X3 }, { X4 }, { Y1 }, { Y2 },
                { Y3 }, { Y4 }, };

        Matrix A = new Matrix(M_a);
        Matrix B = new Matrix(M_b);
        Matrix C = A.solve(B);
        double a = C.get(0, 0);
        double b = C.get(1, 0);
        double c = C.get(2, 0);
        double d = C.get(3, 0);
        double e = C.get(4, 0);
        double f = C.get(5, 0);
        double g = C.get(6, 0);
        double h = C.get(7, 0);


        BufferedImage output = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < imageWidth; i++) {
            for (int j = 0; j < imageHeight; j++) {
                    int x = (int) (((a * i) + (b * j) + c) / ((g * i) + (h * j) + 1));
                    int y = (int) (((d * i) + (e * j) + f) / ((g * i) + (h * j) + 1));
                    int p = imgBuffer.getRGB(x, y);
                    output.setRGB(i, j, p);
            }
        }

        return output;
    }
}