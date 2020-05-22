final class Pair<T> {

   final T left;
   final T right;

   public Pair(T left, T right)
   {
     if (left == null || right == null) { 
       throw new IllegalArgumentException("left and right must be non-null!");
     }
     this.left = left;
     this.right = right;
   }

   public boolean equals(Object o)
   {
     // see @maaartinus answer
     if (! (o instanceof Pair)) { return false; }
     Pair p = (Pair)o;
     return left.equals(p.left) && right.equals(p.right);
   } 

   public int hashCode()
   {
      return 7 * left.hashCode() + 13 * right.hashCode();
   } 
}