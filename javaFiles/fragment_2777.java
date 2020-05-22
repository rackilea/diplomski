public class Category{
   private long id;
   private String name;

   public String getName(){
      return this.name;
   }
   public void setName(String name){
      this.name = name;
   }

   public long getId(){
      return this.id;
   }
   public void setId(Long id){
      this.id = id;
   }
}