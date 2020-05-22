public class ExampleCake extends Cake{
   String shelfLocation;

   public ExampleCake(Cake cake, String shelfLocation){
       super(cake);
       this.shelfLocation = shelfLocation;
   }

   <R> R accept(CakeVisitor<? extends R> visitor){
       return visitor.visit(this);
   }

}