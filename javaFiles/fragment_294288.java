oauthParameters= new GoogleOAuthParameters ();
  oauthParameters.setOAuthConsumerKey (CONSUMER_KEY);
  oauthParameters.setOAuthConsumerSecret (CONSUMER_SECRET);
  oauthParameters.setOAuthType (OAuthType.TWO_LEGGED_OAUTH);
  oauthParameters.setScope ("https://spreadsheets.google.com/feeds/");

  SpreadsheetService spreadsheetService= new SpreadsheetService ("appname");
  spreadsheetService.useSsl ();
  spreadsheetService.setOAuthCredentials (oauthParameters,
    new OAuthHmacSha1Signer ());

  URL feedUrl= new URL (
    "https://spreadsheets.google.com"
      + "/feeds/spreadsheets/private/full?title=Spreadsheetname&xoauth_requestor_id="
      + userEmail);

  SpreadsheetFeed resultFeed= spreadsheetService.getFeed (feedUrl,
    SpreadsheetFeed.class);

  List <SpreadsheetEntry> spreadsheets= resultFeed.getEntries ();
  SpreadsheetEntry spreadsheetEntry= spreadsheets.get (0);

  URL worksheetFeedUrl= spreadsheetEntry.getWorksheetFeedUrl ();
  log.severe (worksheetFeedUrl.toString ());
  WorksheetFeed worksheetFeed= spreadsheetService.getFeed (
    worksheetFeedUrl, WorksheetFeed.class);

  List <WorksheetEntry> worksheetEntrys= worksheetFeed.getEntries ();
  WorksheetEntry worksheetEntry= worksheetEntrys.get (0);

  // Write header line into Spreadsheet
  URL cellFeedUrl= worksheetEntry.getCellFeedUrl ();
  CellFeed cellFeed= spreadsheetService.getFeed (cellFeedUrl,
    CellFeed.class);

  CellEntry cellEntry= new CellEntry (1, 1, "headline1");
  cellFeed.insert (cellEntry);
  cellEntry= new CellEntry (1, 2, "headline2");
  cellFeed.insert (cellEntry);