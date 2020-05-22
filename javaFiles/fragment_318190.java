static int findElement(String a, List<Person> array) {
    for (int i = 0; i < array.size(); i++){
        if (array.get(i).getName().equalsIgnoreCase(a)) {
            return i;
        }   
    }
    return -1;
}