final ServletFileUpload upload = new ServletFileUpload();
final FileItemIterator iter = upload.getItemIterator(request);

 while (iter.hasNext()) {
        //You should have only one element, but you may have several as multipart content
        final FileItemStream item = iter.next();

        final String name = item.getFieldName();
        final InputStream stream = item.openStream();
        //... and here you've got your inputstream
}