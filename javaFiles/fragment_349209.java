public DocumentListEntry moveObjectToFolder(String resourceId, String folderId)
      throws IOException, MalformedURLException, ServiceException, DocumentListException {
    if (resourceId == null || folderId == null) {
      throw new DocumentListException("null passed in for required parameters");
    }

    DocumentListEntry doc = new DocumentListEntry();
    doc.setId(buildUrl(URL_DEFAULT + URL_DOCLIST_FEED + "/" + resourceId).toString());

    URL url = buildUrl(URL_DEFAULT + URL_DOCLIST_FEED + "/" + folderId + URL_FOLDERS);
    return service.insert(url, doc);
  }