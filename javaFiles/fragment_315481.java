int pluss(int...v){
  int plus=0;
  for(int x :v)
  {
    plus=plus+x;
    System.out.println(plus);
    return plus;            
  }
}