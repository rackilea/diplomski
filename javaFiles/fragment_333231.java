public void recursionMethodTwo(Node n) {
   if (n == null) {
       // Standard way to exit a void function without executing remaing code
       // note that return null; doesn't compile
       return;  
   }
   System.out.println(n.getValue());
   recursionMethodTwo(n.next());
}