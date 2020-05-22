public class SaleCake extends Cake{
   String owner;

   public SaleCake(Cake cake, String owner){
       super(cake);
       this.owner = owner;
   }

   <R> R accept(CakeVisitor<? extends R> visitor){
       return visitor.visit(this);
   }

}