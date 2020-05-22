public static abstract class Animal {

   public abstract void attack(Animal other);

   public abstract void beAttackedByCat(Animal cat);
   public abstract void beAttackedByDog(Animal dog);
}

public static class Cat extends Animal {

   @Override
   public void attack(Animal other) {
       other.beAttackedByCat(this);
   }

   public void beAttackedByCat(Animal cat){ // cat > cat }
   public void beAttackedByDog(Animal dog){ // dog > cat }
}

public static class Dog extends Animal {

   @Override
   public void attack(Animal other) {
      other.beAttackedByDog(this);
   }

   public void beAttackedByCat(Animal cat){ // cat > dog }
   public void beAttackedByDog(Animal dog){ // dog > dog }
}