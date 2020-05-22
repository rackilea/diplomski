sales_agents sales = new sales_agents();
seller_thread one = new seller_thread();

ArrayList<Data> books = new ArrayList<>();
int maxSize = 10; // As an example
while (books.size < maxSize) {
    System.out.println(sales.getSales_1() + " has been added to catalogue");
    final Data item = new Data(1, (String) sales.getSales_1(), sales.getValue()); 
    books.add(item);
    one.list().add(item.toString()); // Override your toString() method in Data class to return the string you want 
                                     // (all information you need to know about the object)
}