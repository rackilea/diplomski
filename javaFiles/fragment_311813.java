for (int x = 0; x < studarray.length; x++) {
    Student s = studarray[x];
    if (s == null) {
        continue; // here
    }

    // Check all your fields in a single loop
    if (query.equalsIgnoreCase(s.getStudName())) {

    } else if (Integer.parseInt(query) == s.getStudNum()) {

    } else {
        System.out.println("Student not found using query " + query);
    }
}