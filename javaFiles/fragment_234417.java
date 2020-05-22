public final class ApproximateDuration {
   private final int lowMilliseconds;
   private final int highMilliseconds;

   public ApproximateDuration(int lowMilliseconds, int highMilliseconds) {
      this.lowMilliseconds = lowMilliseconds;
      this.highMilliseconds = highMilliseconds;
   }

   public int getLowMilliseconds() {
      return lowMilliseconds;
   }

   public int getHighMilliseconds() {
      return highMilliseconds;
   }
}