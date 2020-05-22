public AnnotatedDisplayTriangles(BufferedImage image, String image_path, ArrayList<Point[]> triangles) {

    this.image = image;
    this.image_path = image_path;
    this.triangles = triangles;

}

protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Draw image centered.
    int x = (getWidth() - image.getWidth())/2;
    int y = (getHeight() - image.getHeight())/2;
    g.drawImage(image, x, y, this);

    Stroke drawingStroke = new BasicStroke(2);
    Graphics2D graph = (Graphics2D)g;
    graph.setStroke(drawingStroke);
    graph.setPaint(Color.black);


    for(int p = 0; p < triangles.size(); p++){

        Point[] current_triangles = triangles.get(p);

        for(int triangle = 0; triangle < current_triangles.length; triangle++ ){

            Point current = current_triangles[triangle];
            Point next;
            if(triangle == current_triangles.length -1 )
                next = current_triangles[0];
            else
                next = current_triangles[triangle + 1];

            Line2D line = new Line2D.Double(current.x, current.y, next.x, next.y);
            graph.draw(line);

        }
    }
}

public static void main(String image_path,ArrayList<Point[]> triangles, String panel_name) throws IOException {
    String path = image_path;
    BufferedImage image = ImageIO.read(new File(path));
    AnnotatedDisplayTriangles contentPane = new AnnotatedDisplayTriangles(image, path, triangles);
    // You'll want to be sure this component is opaque
    // since it is required for contentPanes. Some
    // LAFs may use non-opaque components.
    contentPane.setOpaque(true);

    int w = image.getWidth();
    int h = image.getHeight();

    JFrame f = new JFrame(panel_name);
//  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(contentPane);
    f.setSize(w,h);
    f.setLocation(200,200);
    f.setVisible(true);
}