@Entity
class Product{

   private Long id;
   private String name;
   ...
}

@Entity
class CartItem{
   private Long id;

   @ManyToOne
   private Product product;

   private int quantity;

...
}

@Entity
class ShoppingCart{
   private Long id;

   @OneToMany
   private Set<CartItem> cartItems;

  ...
}