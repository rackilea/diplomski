public static void ref (StringBuilder refSB) {
  refSB.append("addedWithinRefMethod");  // This works, you're using the object passed by ref
  refSB = null;  // This will not work because you're changing the pointer, not the actual object
}

public static void main(String[] args) {
  StringBuilder sb = new StringBuilder();
  ref(sb);
  System.out.println(sb.toString());  // Will print "addedWithinRefMethod".
}