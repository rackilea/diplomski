abstract class Human {

   public final void goPee() {
       System.out.println("drop pants");
       toStandOrNotToStand();
   }

   protected abstract void toStandOrNotToStand();
}