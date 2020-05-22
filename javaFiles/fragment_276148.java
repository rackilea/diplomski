public class Cake{
   int radius; 
   int height;

   public Cake(Cake cake){
       this.radius = cake.radius;
       this.height = cake.height;
   }

   <R> R accept(CakeVisitor<? extends R> visitor){
       return visitor.visit(this);
   }

}