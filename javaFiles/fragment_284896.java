int commitStep = 100;
int modCount = 0;

while() {
  //... your code
  modCount++;
  if ( modCount % commitStep == 0  ) { 
    BSF.getObjectManager()._commitTransactionDirect(true);
  }
}