static class LoanBook {
    String getTitle() { return ""; }
    boolean isOnLoan() { return true; }
    void setOnLoan(boolean loan) { }
    void setDate(String d){ }
    void setName(String d){ }
}
static class FictionBook extends LoanBook { }
static class NonFictionBook extends LoanBook { }
static Scanner keyboard = new Scanner(System.in);
static FictionBook[] fictionBooksArray = new FictionBook[10];
static NonFictionBook[] nonfictionBookArray = new NonFictionBook[10];