public static Tree subtreeNullSafe(Tree t, int from, int to) {
   return t == null ? null : t.subtree(from, to);
}

public Tree subtree(int from, int to) {
   if (this.key > to) {
     return subtreeNullSafe(this.left, from, to);
   } else if (this.key < from) {
     return subtreeNullSafe(this.right, from, to);
   } else {
     // we know that this.key <= to and this.key >= from
     return new Tree(
       this.key,
       subtreeNullSafe(this.left, from, to),
       subtreeNullSafe(this.right, from, to)
     );
   }
}