@Inheritance(strategy = InheritanceType.JOINED)
class Ssss {

   @ManyToOne
   private Xxxx x;
   public Xxxx getXxxx() {
      return x;
   }
}