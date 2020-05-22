Outer(){
   inner = new Inner(this);
}

Inner(Outer o){
  myouter = o;
}