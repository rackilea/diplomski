for (A p: aList) {
  p.methodFromA();
  if (p instanceof B) {
     B q = (B) p;
     q.methodOnlyBHas();
     // or
     ((B)p).methodOnlyBHas();
  }
}