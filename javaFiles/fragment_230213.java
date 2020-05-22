public class UploadDocument extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
        List<BlobKey> blobKeys = blobs.get("myFile");

        if (blobKeys == null) {
            res.sendRedirect("/");
        } else {

            res.sendRedirect("/serve?blob-key=" + blobKeys.get(0).getKeyString());
        }
    }


}