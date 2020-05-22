void m1 (P p, char z){
  p = new P(z); // this only changes the method argument 'p', not the outer 'p'
}

void someOtherMethod()
  P p = new P('a');
  m1(p, 'z');
  // p has not changed
}