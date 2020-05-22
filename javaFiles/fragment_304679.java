/*
   Your original code:
 */
public void displayBooksFromAuthor(String author)
{
    for(Book b: bookList)
    {
        if (bookList.get(b) == author); // WRONG
        // 1. You can't compare strings with ==
        // 2. Why do you put an ending ; there? If you leave it there
        //    the if statement is useless
        System.out.println(b);
    }
}