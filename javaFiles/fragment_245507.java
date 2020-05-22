AllocationVisitor saveVisitor = new AllocationVisitor() {
  visit(TYPE_SPCIAL1 dto) {//what ever you need}
  visit(TYPE_SPCIAL2 dto) {//what ever TYPE_SPCIAL2 needs}
}
for (AllocationDTO x : listOfAllocationDtos) {
  x.visit(saveVisitor);
}