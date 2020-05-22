public void mergeObj(Map<String, ObjZ> map, Collection<? extends ObjCopier> list) {
  for (ObjCopier obj : list) {
    ObjZ z = getOrCreateObjZFromMap(map, obj.getId());
    obj.copyToObjZ(z);
  }
}