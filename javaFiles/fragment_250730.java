@Override 
public int compare(String left, String right) {
 if (left == right) {
   return 0;
 }
 if (left == null) {
   return 1;
 }
 if (right == null) {
   return -1;
 }
 return 0;
 }