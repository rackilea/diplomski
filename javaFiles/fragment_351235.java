Iterator<?> iter1 = ...;
Iterator<?> iter2 = ...;             // or: int index = 0;

while (iter1.hasNext() &&
           iter2.hasNext()) {        // or: index < MAX

   Object item1 = iter1.next();
   Object item2 = iter2.next();      // or: index++;

   doSomething(item1, item2);        // or: doSomething(item1, index);

}

// perhaps additional handling if one ran out before the other