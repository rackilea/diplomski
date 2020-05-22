private int searchByName(String s) {
    for(Map.Entry<Integer, HashMap<String, String>> entry : students.entrySet()) {
        HashMap student = entry.getValue(); // Hashmap containing first and lastname
        if (student.containsKey(s)) // If name match
            return entry.getKey(); // Return the student ID
    }
    return 0; // Student not found
}