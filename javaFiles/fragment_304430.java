@Entity
class CartItem{
   private Long id;

   @ManyToOne
   private Product product;

   @ManyToOne
   private ShppingCart shoppingCart;

   private int quantity;

...
}

@Entity
class ShoppingCart{
   private Long id;

   @OneToMany(mappedBy = "shoppingCart")
   private Set<CartItem> cartItems;

  ...
}