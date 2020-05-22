Object o;

    o = (Integer) 42; // works! Boxing conversion!
    o = (Number) 42;  // works! Autoboxing then widening reference conversion!
    o = (Object) 42;  // works! Autoboxing then widening reference conversion!
    o = 42; // YES! This also compiles!!!

    o = (String) ((Object) 42); // compiles fine!
    // will throw ClassCastException at run-time

    o = (String) 42; // DOESN'T COMPILE!!!