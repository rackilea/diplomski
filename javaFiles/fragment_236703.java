public enum SoonilsDataType {
      A, B, C;

      // Just an example of what's possible
      public static SoonilsDataType getCompositeValue(SoonilsDataType item1,
           SoonilsDataType item2) {
           if (item1.equals(A) && 
                     item2.equals(B)) {
                return C;
           }
      }
 }