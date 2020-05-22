public List<Book> books = new AutoPopulatingList<Book>(new ElementFactory<Book>() {
    @Override
    public Book createElement(final int index) throws ElementInstantiationException {
         //call the constructor as you need
         return new Book();
    }       
});