printAll(char[] c, int n, String start){
  if(start.length >= n){
    System.out.println(start)
  }else{
    for(char x in c){ // not a valid syntax in Java
      printAll(c, n, start+x);
    }
  }
}