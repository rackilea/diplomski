List<String> vegetables = new ArrayList<>(); // Fill the lists somehow
List<String> fruits = new ArrayList<>();
List<List<String>> matrix = new ArrayList<>();    

for(String vegetable : vegetables) {
    List<String> row = new ArrayList<String>();
    row.add(vegetable);
    for(String fruit : fruits) {
        row.add(fruit);
    }
    matrix.add(row);
}