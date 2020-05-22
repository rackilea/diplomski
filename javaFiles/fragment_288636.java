int i = 0;
for (Student student : students) {
    // Add null checks if first/last name can be null
    if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
        System.out.println("Found student at " + i);
        break;
    }
    i++;
}