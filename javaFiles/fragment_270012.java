for(Foo foo : foolist){
    if (foo==null){
        continue;// with this the "for loop" will skip, and get the next element in the
                 // list, in other words, it will execute the next loop,
                 //ignoring the rest of the current loop
    }
    foo.dosomething();
    foo.dosomethingElse();
}