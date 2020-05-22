static void issueBook() {
    int choice = Integer.parseInt(getUserInput("1. Fiction: 2. Non Fiction:"));
    if (choice == 1) {
        takeOutBook(fictionBooksArray);
    } else if (choice == 0) {
        takeOutBook(nonfictionBookArray);
    }
}

static LoanBook find(LoanBook[] books, String title) {
    for (LoanBook book : books) {
        if (book.getTitle().equals(title) && !book.isOnLoan()) {
            return book; // When the book is found, exit the loop and return the book
        }
    }
    return null; // Returns null if book not found
}

static String getUserInput(String prompt) {
    System.out.println(prompt);
    return keyboard.next(); // You can then use Integer.parseInt(String param) to get the int value
}

static void takeOutBook(LoanBook[] books) {
    String title = getUserInput("Please enter title of the book to loan");
    String name = getUserInput("Please enter your name: ");
    String date = "???";

    LoanBook book = find(fictionBooksArray, title);
    if (book != null) {
        book.setOnLoan(true);
        book.setName(name);
        book.setDate(date);
    } else {
        System.out.println("The title has not been found, please try again");
        takeOutBook(books); // The method calls itself in an loop until the user inserts valid information
    }
}