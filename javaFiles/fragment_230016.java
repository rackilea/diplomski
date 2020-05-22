{
  "type": "def",
  " results": [
    {
      "name": "def product one",
      "price": "728.0000",
    },
    {
      "name": "def product two",
      "price": "1263.0000",
    },
  ]
}



public final class ProductResponse{

       private String status;
       private String message;
       private List<Products> product = new Arraylist<>();

       // Getters And Setters
    }

    public final class Products{

       private String type; // type of product // ABC or DEF
       private List<Result> results = new Arraylist<>(); 

      // Getters And Setters
    }


     public final class Result{

       private String name;
       private String price;


     // Getters And Setters
    }