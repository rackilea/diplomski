public void putStuff(Pair<? super Manager> managers) {
    if (...){
       managers.setFirst(new Manager());
    }
    else if (...){
    managers.setFirst(new Executive());
   }
}