// or @SuppressWarnings("unchecked")
 @SuppressWarnings("rawtypes")
 public void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     if (ServletFileUpload.isMultipartContent(request)) {
         final FileItemFactory   factory = new DiskFileItemFactory();
         final ServletFileUpload upload  = new ServletFileUpload(factory);

         try {
             final List items = upload.parseRequest(request);

             for (Iterator itr = items.iterator(); itr.hasNext();) {
                 final FileItem item = (FileItem) itr.next();

                 if (!item.isFormField()) {
                    /*
                     * TODO: (for you)
                     *  1. Verify that file item is an image type.
                     *  2. And do whatever you want with it.
                     */
                 }
             }
         } catch (FileUploadException e) {
             e.printStackTrace();
         }
     }
 }