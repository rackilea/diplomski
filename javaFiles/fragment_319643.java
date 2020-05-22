static class FooBar implements Comparable<FooBar> {
   String foo;
   int bar, etal;

   int compareTo(FooBar other) {
     ... comparison logic here...
   }

}