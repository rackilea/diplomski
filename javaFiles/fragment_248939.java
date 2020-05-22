public ImprovedLegacyObject(LegacyObject legacyObject) {        
  ...
  //copy stuff over

  this.someField = legacyObject.getSomeField();
  this.anotherField = legacyObject.getAnotherField();
  ...
}