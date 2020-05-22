public void run(){
  int workRow;
  synchronized(this){
    workRow = findNextUnprosessedRow();
  }
  for(int i=0; i<matrix[workRow].length; i++){
    //do the work
  }
}