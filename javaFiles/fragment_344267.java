int totalPrice = 0;
    ShoppingCartVisitor cart = new ShoppingCartVisitorImpl();
    ItemElement element1 = new Fruit(2,3,"Apple");
    ItemElement element2 = new Book(30,"some ISBN number");
    totalPrice += element1.visit(cart);
    totalPrice += element2.visit(cart);