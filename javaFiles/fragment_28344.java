classTable = new TableContainer[8];
classTable[0] = new TableContainer();
//...later
if(classTable[0] != null) {  //will pass for [0], but not for [1]
  classTable[0].key
}