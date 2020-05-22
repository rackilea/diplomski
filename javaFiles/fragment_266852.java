Book book = new Book();
Vinyl vinyl = new Vinyl();
List<Product> products = new List<>();
products.add(book);
products.add(vinyl);
CompositeProduct vinylBook = new CompositeProduct(products);