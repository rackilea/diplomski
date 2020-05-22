protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // First get image file name as request pathinfo (or parameter, whatever you want).
    String imageFilename = request.getPathInfo().substring(1);

    // And get the thumbnail dimensions as request parameters as well.
    int thumbWidth = Integer.parseInt(request.getParameter("w"));
    int thumbHeight = Integer.parseInt(request.getParameter("h"));

    // Then get an InputStream of image from for example local disk file system.
    InputStream imageInput = new FileInputStream(new File("/images", imageFilename));

    // Now scale the image using Java 2D API to the desired thumb size.
    Image image = ImageIO.read(imageInput);
    BufferedImage thumb = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = thumb.createGraphics();
    graphics2D.setBackground(Color.WHITE);
    graphics2D.setPaint(Color.WHITE); 
    graphics2D.fillRect(0, 0, thumbWidth, thumbHeight);
    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    graphics2D.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);

    // Write the image as JPG to the response along with correct content type.
    response.setContentType("image/jpeg");
    ImageIO.write(thumb, "JPG", response.getOutputStream());
}