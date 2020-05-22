class Term {
  char c;  //the two values inside your Term class
  int i;

  @Override
  public boolean equals(Object o){
    //checks omitted
    Term other = (Term)o;
    //now compare the contents:
    return i==other.i && c==other.c;
  }
}