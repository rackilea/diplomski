@RequestMapping (value = "/test", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
@ResponseBody
public byte[] test(HttpServletRequest request) {
    //curl -v http://localhost:8080/Bikeshop/admin/test > /dev/null
    String realPath = request.getSession().getServletContext().getRealPath("/resources/images/catalog/sample.jpg");

    try {
        InputStream is = new FileInputStream(realPath);
        BufferedImage img = ImageIO.read(is);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", bos);
        return bos.toByteArray();
    } catch (FileNotFoundException e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    } catch (IOException e) {
        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }

    return null;
}