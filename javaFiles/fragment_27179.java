%module test

%ignore A_::b; // We will wrap this another way
%typemap(javacode) A %{
  public B[] getB() {
    B[] ret = new B[getNumBs()];
    for (int i = 0; i < ret.length; ++i) {
      ret[i] = getB(i);
    }
    return ret;
  }
%}

// Or %include etc.
%inline %{
typedef struct B_ {
 /* something */
} B;

typedef struct A_ {
    int numBs; /* The count of Bs in the array bellow */
    B *b;
} A;
%}

%javamethodmodifiers A_::getB(size_t pos) "private";
%extend A_ {
  // This defaults to non-owning, which is exactly what we want
  B *getB(size_t pos) {
    assert(pos < $self->numBs); // TODO: real error handling
    return $self->b+pos;
  }
}