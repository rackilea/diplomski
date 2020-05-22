// Returns the book if it exists in books, otherwise returns null
static LoanBook find(LoanBook[] books, String title)

// Prints the prompt to the console, returns whatever the user types next
static String getUserInput(String prompt)

// Takes the input title and name, tries to find the book in the array
// If it detects the find method has failed by returning null, it prompts
// the user for new information
static void takeOutBook(LoanBook[] books)

// The big method is much clearer now, this depends on the other methods to work
static void issueBook() {
    int choice = Integer.parseInt(getUserInput("1. Fiction: 2. Non Fiction:"));
    if (choice == 1) {
        takeOutBook(fictionBooksArray);
    } else if (choice == 0) {
        takeOutBook(nonfictionBookArray);
    }
}