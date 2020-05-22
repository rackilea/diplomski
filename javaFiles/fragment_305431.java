{
    vector.add(a);
    vector.add(b);

 /*
  * a and b need not be added to the vector in sequence.
  * If two threads execute this block, the vector will contain one of {a,b,a,b}, {a,a,b,b}....
  */
}