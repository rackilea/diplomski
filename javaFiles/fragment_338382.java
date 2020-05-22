boolean found = false;
for (int d = 0; d < database.length; d++) {
    if (database[d].equals(username)) {
        found = true;
    }
}

if (found) {
    System.out.println("_____________");
} else {
    System.out.println("Username Not Found.");
}