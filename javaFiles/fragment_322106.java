671     public boolean isEmpty() {
  672         return count == 0;
  673     }

 1013     public boolean equals(Object anObject) {
 1014         if (this == anObject) {
 1015             return true;
 1016         }
 1017         if (anObject instanceof String) {
 1018             String anotherString = (String)anObject;
 1019             int n = count;
 1020             if (n == anotherString.count) {
 1021                 char v1[] = value;
 1022                 char v2[] = anotherString.value;
 1023                 int i = offset;
 1024                 int j = anotherString.offset;
 1025                 while (n-- != 0) {
 1026                     if (v1[i++] != v2[j++])
 1027                         return false;
 1028                 }
 1029                 return true;
 1030             }
 1031         }
 1032         return false;
 1033     }