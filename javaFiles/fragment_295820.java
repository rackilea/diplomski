Scanner s = new Scanner(new File(“MasterCopy.txt”));
HashSet<String> masterlist = new HashSet<String>();
while (s.hasNext()){
  masterlist.put(s.next());
}
s.close();
s = new Scanner(new File(“ClientCopy.txt”));
HashSet<String> clientlist = new HashSet<String>();
while (s.hasNext()){
  clientlist.put(s.next());
}
s.close();

//Do the comparison
ArrayList<String> missing = new ArrayList<String>();
ArrayList<String> excess = new ArrayList<String>();
//Check for missing or excess
for(String line : masterlist){
    if(clientlist.get(line) == null) missing.add(line);
}
for(String line : clientlist){
    if(masterlist.get(line) == null) excess.add(line);
}