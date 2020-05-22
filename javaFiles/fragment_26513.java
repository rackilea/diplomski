// From the example: http://stackoverflow.com/questions/1513603/how-to-upload-and-store-an-image-with-google-app-engine-java
FileItemIterator iter = upload.getItemIterator(req);
// Parse the request
while (iter.hasNext()) {
    FileItemStream item = iter.next();
    String name = item.getFieldName();
    InputStream stream = item.openStream();
    if (item.isFormField()) {
        System.out.println("Form field " + name + " with value "
            + Streams.asString(stream) + " detected.");
    } else {
        // Image here.
        System.out.println("File field " + name + " with file name "
            + item.getName() + " detected.");
        // Process the input stream
        ...
    }
}