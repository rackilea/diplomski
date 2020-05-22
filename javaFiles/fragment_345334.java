class Foo {
   int i;
   public boolean equals(Object obj) {
      return ((Foo) obj).i < this.i;
   }
}