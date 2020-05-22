DatabaseHelper db = ...;
int tripID = ...;
int fishID = ...;
Cursor c = db.getFish(tripID, fishID);           
String species = c.getString(0);
int size = Integer.parseInt(c.getString(1));
Fish fish = new Fish(species, size);