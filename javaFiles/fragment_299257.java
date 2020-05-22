String html="";
for (int i = 0; i < emojilist.length-1; i++) { 
     html += "<img src ='"+ emojilist[i] +"'/>";
}

Spanned cs = Html.fromHtml(html, imageGetter, null); 
textviewobject.setText(cs);