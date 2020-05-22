public class C {

   private B b;

   C(B b) {
      this.b = b;
   }

   public refresh() {
      b.refresh();
  }
}