long lastModified = new DateTime(
    new Date(file.lastModified()), TimeZone.getDefault()
).getValue();

if(lastModified > entry.getUpdated().getValue()) {
    //update the file
}