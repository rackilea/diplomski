Map<String,String> extensionToMimeType = new HashMap<String,String>();
extensionToMimeType.put("pdf", "application/pdf");
extensionToMimeType.put("doc", "application/msword");
// and the rest

int lastDot = fileName.lastIndexOf(".");
String mimeType;
if (lastDot==-1) {
    mimeType = NO_EXTENSION_MIME_TYPE;
} else {
    String extension = fileName.substring(lastDot+1);
    mimeType = extensionToMimeType.get(extension);
    if (mimeType == null) {
        mimeType = UNKNOWN_EXTENSION_MIME_TYPE;
    }
}