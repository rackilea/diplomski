function getDimensions () {
  var data = Sheets.Spreadsheets.Values.get("SPREADSHEET_ID","SHEET_NAME"); 
  // returned value list[][]
  var arr = data.values;

  // last row with data
  var rows = arr.length;

  // last column with data
  var cols = arr.reduce(function(accumulator, el, i) {
    if (i == 1) { accumulator = accumulator.length } 
    return Math.max(accumulator, el.length);
  });
}