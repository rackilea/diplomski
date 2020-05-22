try {
     ...
} catch(Exception e) {
    System.out.println("Error: invalid input:" + e.getMessage());
    again = true;
    keyboard.next(); // Ignore whatever is entered
}