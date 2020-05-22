Elements a = doc.select("div#footer div.row2 div.content div.row2col1"
        + " div.moduletable div.custom p span");
//                                      ^^^^^---add this part
String spanValue = a.get(1).text().trim();
if (spanValue.matches("\\d+")) {// I changed this condition a bit just for tests
    aw = spanValue;
} else {
    aw = "oops";
}