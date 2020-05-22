@Stateful
 public class ShoppingCartImpl implements ShoppingCart{

   private Integer uid;
   private ArrayList<String> products;

   @PostConstruct
   private void create(){
     producs = new ArrayList<String>();
   }

   @Override
   public void init(Integer id){
     if(id==null){
       uid = id;
     }
  }

  @Override
  public void addToCart(String product){
     if(product!=null){
        products.add(product);
     }

 }


 }