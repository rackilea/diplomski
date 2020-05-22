private ArrayList<String> selectedAsList(Map<String, List<String>> selectedItems){
     ArrayList<String> result =  new ArrayList<>();
    for(List<String> students: selectedItems.values())
        result.addAll(students);
    return result;
}