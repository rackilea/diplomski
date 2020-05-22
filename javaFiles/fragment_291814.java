String url = ...
String urlToID = String.valueOf(url.hashCode());
...
// check if that urlToID is already present
boolean present = false;
for (Node child : myContainer.getChildren()) {
  if (child.getId().equals(urlToID)) {
    present = true;
    break;
}
if (!present) {
  Hyperlink link = ...
  link.setId(urlToID);
  myContainer.getChildren().add(link);
}