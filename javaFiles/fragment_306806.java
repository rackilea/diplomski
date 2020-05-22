function priceEmail() {

  var sheet, data, page, table="";

  sheet = SpreadsheetApp.getActiveSheet();
  data  = sheet.getRange(2, 2, 21, 2).getValues();  // Note that the script will only look at the first 20 rows.

  try {
    for (i in data) {      
      if (data[i][0] !== "") {
        page = UrlFetchApp.fetch(
          "http://ctrlq.org/aws/lookup/", {
            "method": "post", "payload": {"url":data[i][0]}
          }).getContentText();

        table = table + tableRow(page);                
      }     
    }
  } catch (e) {
    Logger.log(e.toString());
    // Following line inserted to include any error messages in your daily email(s).
    table += "<tr><td><strong>Error:</strong></td><td>" + e + " (url: \"" + data[i][0] + "\")</td></tr>";  
  }
  // ...