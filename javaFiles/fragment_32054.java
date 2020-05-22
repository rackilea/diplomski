........
// Access the first worksheet
Worksheet worksheet = book.getWorksheets().get(0);

// Set the print area with your desired range
worksheet.getPageSetup().setPrintArea("E8:H15");

// Set all margins as 0 to get remove unnecessary white space
worksheet.getPageSetup().setLeftMargin(0);
worksheet.getPageSetup().setRightMargin(0);
worksheet.getPageSetup().setTopMargin(0);
worksheet.getPageSetup().setBottomMargin(0);

..........