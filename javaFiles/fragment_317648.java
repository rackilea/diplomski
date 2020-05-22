LinkedList<Object> list = ...;

// Loop 1:
int size = list.size();
for (int i = 0; i<size; i++) {
   Object o = list.get(i);
   /// do stuff
}

// Loop 2:
for (Object o : list) {
  // do stuff
}

// Loop 3:
Iterator<Object> it = list.iterator();
while (it.hasNext()) {
  Object o = it.next();
  // do stuff
}