public class ShowImage extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String par = req.getParameter("name");
        if (par != null) {
            Query query = new Query("__BlobInfo__");
            query.addFilter("filename", Query.FilterOperator.EQUAL, req.getParameter("name"));

            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            PreparedQuery pq = datastore.prepare(query);
            List<Entity> entList = pq.asList(FetchOptions.Builder.withLimit(1));
            if (entList.size() > 0) {
                BlobKey blobKey = new BlobKey(entList.get(0).getKey().getName());
                BlobInfoFactory bi = new BlobInfoFactory();
                String fname = bi.loadBlobInfo(blobKey).getFilename();
                if (fname.contains(".jpg") || fname.contains(".JPG") || fname.contains(".jpeg") ||
                        fname.contains(".JPEG") || fname.contains(".png") || fname.contains(".PNG") ||
                        fname.contains(".GIF") || fname.contains(".gif") || fname.contains(".BMP") ||
                        fname.contains(".bmp")) {
                    res.setContentType("application/octet-stream");
                    res.setHeader("Content-Type", "save as filename=" + fname);
                    ImagesService imagesService = ImagesServiceFactory.getImagesService();

                    Image oldImage = ImagesServiceFactory.makeImageFromBlob(blobKey);
                    Transform resize = ImagesServiceFactory.makeResize(580, 270,true);

                    Image newImage = imagesService.applyTransform(resize, oldImage);

                    byte[] newImageData = newImage.getImageData();
                    OutputStream outputStream = res.getOutputStream();
                    outputStream.write(newImageData);
                } else {
                    res.setContentType("application/x-download");
                    res.setHeader("Content-Disposition", "attachment; filename=" + fname);
                    blobstoreService.serve(blobKey, res);
                }


            } else {
                res.setContentType("text/plain");
                res.setCharacterEncoding("UTF-8");
                res.getOutputStream().write("Bu isimde bir dosya bulunamadı".getBytes());
            }
        } else {

            res.setContentType("text/plain");
            res.setCharacterEncoding("UTF-8");
            res.getOutputStream().write("Lütfen parametre giriniz. Örnek: name=resim.jpg".getBytes());
        }
    }
}