HashMap<String, String> file1Map = new HashMap<String, String>();

while ((String line = file1.readLine()) != null) {
  array =line.split(",");
  key = array[0]+array[1]+array[2]+array[8];
  file1Map.put(key, key);
}

while ((String line = file2.readLine()) != null) {
  array =line.split(",");
  key = array[0]+array[1]+array[2]+array[8];
  if (file1Map.containsKey(key)) {
    //if file1 has same line in file2
  }
  else {
    //if file1 doesn't have line like in file2
  }
}