String txt = "<html>";
for (Element tag : tags) {
  txt += tag.text() + "<br/>";
}
txt += "</html>";
label.setText(txt);