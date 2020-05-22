String text = "abcada";
String textToBeColored = "a";

String htmlText = text.replace(textToBeColored,"<font color='#c5c5c5'>"+textToBeColored +"</font>");
// Only letter a would be displayed in a different color.
txtView.setText(Html.fromHtml(htmlText);