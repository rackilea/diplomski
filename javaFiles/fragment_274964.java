public static List<String[]> csvToListOfArrays(String file) throws IOException {
   BufferedReader reader = new BufferedReader(new FileReader(file)); 
   List<String[]> arrays = new ArrayList<String[]>(); 
   String line; 
   while ((line = reader.readLine()) != null) {
        String[] tokens = line.split(",");
        arrays.add(tokens);
   }
   return arrays;
}