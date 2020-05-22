void foo() {
  Thing one = new Thing("hello");  // 1
  bar(one);
  one.print();                   // 5
}

void bar(Thing two) {            // 2
  two = new Thing("bye");        // 3
}                                // 4