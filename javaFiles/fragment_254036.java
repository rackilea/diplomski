// Validation utility for mime types
    private List<String> extractValidMimeTypes(String[] mimeTypes) {
        List<String> results = new ArrayList<String>();
        List<String> mimes;
        if (mimeTypes.length() == 1 && mimeTypes[0].contains(",")) {
            mimes = Arrays.asList(mimeTypes[0].split(","));
        } else {
            mimes = Arrays.asList(mimeTypes);
        }
        MimeTypeMap mtm = MimeTypeMap.getSingleton();
        for (String mime : mimes) {
            if (mime != null && mime.trim().startsWith(".")) {
                String extensionWithoutDot = mime.trim().substring(1, mime.trim().length());
                String derivedMime = mtm.getMimeTypeFromExtension(extensionWithoutDot);
                if (derivedMime != null && !results.contains(derivedMime)) {
                    // adds valid mime type derived from the file extension
                    results.add(derivedMime);
                }
            } else if (mtm.getExtensionFromMimeType(mime) != null && !results.contains(mime)) {
                // adds valid mime type checked agains file extensions mappings
                results.add(mime);
            }
        }
        return results;
    }


public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> filePathsCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
    Intent intent = fileChooserParams.createIntent();
    List<String> validMimeTypes = extractValidMimeTypes(fileChooserParams.getAcceptTypes());
    if (validMimeTypes.isEmpty()) {
        intent.setType(DEFAULT_MIME_TYPE);
    } else {
        intent.setType(String.join(" ", validMimeTypes));
    }
    ...