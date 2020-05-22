class ObjA implements ObjCopier {
  ...

  String getId() { return id; } 

  void copyToObjZ(ObjZ z) {
    z.setName(name);
    z.setA(a);
    ...
  }

}