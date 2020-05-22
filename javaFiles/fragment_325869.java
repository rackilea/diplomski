%newobject Parent::create;

%typemap(javacode) Parent %{
  private Child childReference;
%}

%typemap(javaout) Parent* create(Child&) {
    long cPtr = $jnicall;
    if (cPtr == 0) {
        return null;
    } else {
        Parent p = new Parent(cPtr, $owner);
        p.childReference=child;
        return p;
    }
}