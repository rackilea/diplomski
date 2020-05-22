PDFDocumentReader document = new PDFDocumentReader(<byteArraOfThePDF>);
PageDetail pageDetail = new PageDetail("<docIDanything>", "", <pagenumber>, "");
ResourceDetail det = document.getPageAsImage(pageDetail);

BufferedImage image = ImageIO.read(new ByteArrayInputStream(det.getBytes()));
File file = new File("d:/img2.jpg");
ImageIO.write(image, "jpg", file);