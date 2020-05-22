if (contentDispositionFileName != null) {
   submd.set("resourceName", contentDispositionFileName);
} else {
    Map<String, String> contentTypeParameters = ((MaximalBodyDescriptor)body).getContentTypeParameters();
    String contentTypeFilename = (String)contentTypeParameters.get("name");
    submd.set("resourceName", contentTypeFilename);
}