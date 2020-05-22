ArrayList<String> nameArray = new ArrayList<String>();

for (String name: fileNames){
   name = name.substring(0, name.indexOf("."));
   nameArray.add(name);
   Log.d("Files", "FileName:" + name);
}