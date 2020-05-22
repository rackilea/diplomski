lastSlashIndex = name.lastIndexOf("\\");
if (lastSlashIndex == -1) {
    lastSlashIndex = name.lastIndexOf("/"); //unix client
}
String shortName = name;
if (lastSlashIndex != -1) {
    shortName = name.substring(lastSlashIndex);
}