public final class Range {
   /** Inclusive as minutes since midnight */
   public final int start, end;
   public Range(int start, int end) {
     assert end >= start;
   }

   /** @param time in minutes since midnight */
   public boolean contains(int time) {
     return start <= time && time <= end;
   }

   public static Range valueOf(String s) {
     assert VALID_RANGE.matcher(s).matches() : s;
     return new Range(minutesInDay(s.substring(0, 5)),
                      minutesInDay(s.substring(6));
   }

   private static int minutesInDay(String time) {
     return Integer.valueOf(time.substring(0, 2)) * 60
         + Integer.valueOf(time.substring(3));
   }
 }