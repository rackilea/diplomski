Set<String> bookRefs = new HashSet<String>();
for (BookDTO bookdto : bookList)
{
    if (!bookRefs.add(bookDto.getBookRef()))
    {
        // if we are here we tried to insert the same bookRef more than once...
    }
}