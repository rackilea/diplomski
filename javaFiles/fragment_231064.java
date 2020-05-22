public void addEbook(String author, String title, double price, String isbn) // adds ebooks to the array
{
    if(count==ebooks.length-1) {
        return;
    }
    Ebook anEbook = new Ebook(author,title,price,isbn);

    ebooks[count] = anEbook;
    total_cost += price;
    System.out.printf("%s%n", anEbook);
    count++; // used to find the total number of ebooks
}