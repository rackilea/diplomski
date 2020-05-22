RWayTrieST<String> foo = ...;
RWayTrieST<Integer> bar = ...;
Object[] stringArray = foo.new Node<String>[];  // compiler error, but pretend it's allowed
stringArray[0] = foo.new Node<String>();   // OK
stringArray[1] = bar.new Node<Integer>();  // An ArrayStoreException should be thrown,
                                            // but the runtime can't detect it, because generic types are erased.