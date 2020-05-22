public String[] getFiles(String initialDir) {
   List<String> files = new ArrayList<String>();
   ...
       files.add(aLovelyFile);
   ...
       String[] moarFiles = getFiles(aLovelyDirectory);
       files.addAll(Arrays.asList(moarFiles));
   ...
   return files.toArray(new String[0]);
}