SpreadsheetEntry spreadsheet = null;
URL metafeedUrl = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");

SpreadsheetFeed spreadsheetFeed = service.getFeed(metafeedUrl, SpreadsheetFeed.class);
List<SpreadsheetEntry> spreadsheets = spreadsheetFeed.getEntries();
for (SpreadsheetEntry entry : spreadsheets) {
   if (entry.getTitle().getPlainText().equals(spreadsheetTitle)) {
      spreadsheet = entry;
   }
}

if (spreadsheet == null) {
    throw new FileNotFoundException("Cannot find the required spreadsheet '" + spreadsheetTitle + "'");
}

WorksheetEntry worksheet = null;
WorksheetFeed worksheetFeed = service.getFeed(spreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);
List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
    for (WorksheetEntry entry : worksheets) {
    if (entry.getTitle().getPlainText().equals(worksheetTitle)) {
         worksheet = entry;
    }
}

if (worksheet == null) {
    throw new FileNotFoundException("Cannot find the required worksheet '" + worksheetTitle + "'");
}

URL listFeedUrl = worksheet.getListFeedUrl();
ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);