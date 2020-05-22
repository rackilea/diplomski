String decision = "No";
do {
    System.out.println("Would you like to add another book?");
    decision = keybd.nextLine();
    if (decision.equals("Yes")) {
        // Get information about book
        String anyTitle = keybd.nextLine();
        String anyAuthor = keybd.nextLine();
        addBooks(anyTitle,anyAuthor);
    }
} while (decision.equals("Yes"));