public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException {
        BlobKey blobKey = new BlobKey(req.getParameter("blob-key")); //example
        String filename = "someName.docx";
        res.setHeader("Content-Disposition", "attachment; filename=\"" +fileName +\"");

        blobstoreService.serve(blobKey, res);
    }