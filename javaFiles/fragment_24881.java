// Save chart data
FileOutputStream out = null;

out = openFileOutput(recordName, MODE_PRIVATE);
ObjectOutputStream outputStream = new ObjectOutputStream(out);
ArrayList<MyEntry> myEntries = new ArrayList<>();

for (int k = 0; k < entries.size(); k++) {
  Entry currentEntry = entries.get(k);
  MyEntry currentMyEntry = new MyEntry();
  currentMyEntry.setX(currentEntry.getX());
  currentMyEntry.setY(currentEntry.getY());
  myEntries.add(currentMyEntry);
}

outputStream.writeObject(myEntries);
outputStream.close();