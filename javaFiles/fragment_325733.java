public class ProductDao {
     public Product create(Product p){
        p.setCreationDate(new Date());
        dao.create(p);
        return p;
     }
 }