List<Integer> x = Arrays.asList(1, 2, 3);

x.get(0) == 1;  // this is true  **WARNING** comments have pointed out this only works for Integers -128 to 127 due to integer caching.  Use .equals

int foo = x.get(1);  // this doesn't need a cast

x.add(4);  // this doesn't need to be wrapped