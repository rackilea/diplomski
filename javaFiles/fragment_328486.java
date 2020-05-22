ArrayList<String> myTags = new ArrayList<>();
// fetch tags
myTags.add(currentTag);
// set text to first `TextView` & check if it is already added
if (!myTags.contains(currentTag)) {
   rfid.setText(currentTag);
}