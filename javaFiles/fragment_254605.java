private MyMutableObject mutable = ...

public MyMutableObject getMutableObject() {
   return new MyMutableObject(this.mutable);
}
`