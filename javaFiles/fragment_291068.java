do {
    System.out.println("Would you like to add another book?");
    String decision = keybd.nextLine();
    if (decision.equals("Yes")) {
        addBook();
    }
} while (decision.equals("Yes"));