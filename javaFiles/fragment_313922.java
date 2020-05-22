ArrayList<String> columnEntries = new ArrayList<String>();

//populate the array list here, and then...

Radiogroup radiogroup = new Radiogroup();

for(String entry: columnEntries){
 radiogroup.appendItem(entry, entry);
}