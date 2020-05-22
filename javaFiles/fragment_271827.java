public boolean equals(Object anObject) {
     if (this == anObject) {      // Reference equality
         return true;
     }
     if (anObject instanceof String) {
         String anotherString = (String)anObject;
         int n = count;
         if (n == anotherString.count) {  // Are the strings the same size?
             char v1[] = value;
             char v2[] = anotherString.value;
             int i = offset;
             int j = anotherString.offset;
             while (n-- != 0) {
                 if (v1[i++] != v2[j++])        // Compare each character
                     return false;
             }
             return true;
         }
     }
     return false;
}