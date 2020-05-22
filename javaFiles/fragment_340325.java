WorksheetFeed worksheetFeed = s.getFeed(spreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);
List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
WorksheetEntry worksheet = worksheets.get(0);

URL cellFeedUrl= worksheet.getCellFeedUrl ();
CellFeed cellFeed= s.getFeed (cellFeedUrl, CellFeed.class);

CellEntry cellEntry= new CellEntry (1, 1, "aa");
cellFeed.insert (cellEntry);