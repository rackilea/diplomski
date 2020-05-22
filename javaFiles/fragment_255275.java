public static void main(String[] args) {
    ArrayList<ArrayList<String>> couples = family();

    for (ArrayList<String> couple : couples) {
        for (String person : couple) {
            System.out.println(person);
        }
    }
}