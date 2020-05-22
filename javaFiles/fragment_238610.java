//I will fill my list with lines from file
List<String> lines = Files.readAllLines(Paths.get("input.txt"));

Map<String, String> dictionary = new LinkedHashMap<>();
                                //   LinkedHashMap - preserves order of insertion
                                //   if you don't need to preserve it use HashMap
                                //   if you want to sort elements by value of key 
                                //   use TreeMap

//lets split each line to key and value like you already do
//and put it into dictionary
for (String line : lines){
    String[] tokens = line.split("\\s+",2); //split on one (or more continues whitespaces)
                                            //but limit size of array to 2
    dictionary.put(tokens[0], tokens[1]);   //I assume "rest of the line" is mandatory, 
                                            //otherwise tokens[1] will not exist
}