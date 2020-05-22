beginTransaction(); // First call
try{
  doSomeWorkOnDB();
  commit();
} except (...){
  rollback();
}
...
beginTransaction(); // Second call
try{
  doOtherWorkOnDB();
  commit();
} except (...){
  rollback();
}