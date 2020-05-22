// Make a request to the API and get all spreadsheets.
    SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL,
        SpreadsheetFeed.class);
    List<SpreadsheetEntry> spreadsheets = feed.getEntries();

   if (spreadsheets.size() == 0) {
      // TODO: There were no spreadsheets, act accordingly.
    }