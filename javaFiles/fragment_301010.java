class CollectionUtilities {
   static <T> ArrayList<T> arrayList () { return new ArrayList<T>(); }
}

...

import static CollectionUtilities.*;

List<Integer> numbers = arrayList();