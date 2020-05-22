private void InitCal(Month month, int year) {
  if(calPanel!= null){
    this.remove(calPanel);
    this.revalidate();
}
...