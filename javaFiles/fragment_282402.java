DocsService docsService = new DocsService("MySampleApplication-v3");
    docsService.setUserCredentials(USERNAME, PASSWORD);
    URL GOOGLE_DRIVE_FEED_URL = new URL("https://docs.google.com/feeds/default/private/full/");
    DocumentListEntry documentListEntry = new com.google.gdata.data.docs.SpreadsheetEntry();
    documentListEntry.setTitle(new PlainTextConstruct("Spreadsheet_name"));
    documentListEntry = docsService.insert(GOOGLE_DRIVE_FEED_URL, documentListEntry);