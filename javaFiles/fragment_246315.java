...
String titel = f.getString(TAG_TITEL);
String description = f.getString(TAG_BESCHREIBUNG);
int imageUrl = f.getString(TAG_IMAGE); //Assuming TAG_IMAGE is the name of the Json attribute with the image url

 DataObject obj = new DataObject(
                titel,
                description,
                imageUrl);
...