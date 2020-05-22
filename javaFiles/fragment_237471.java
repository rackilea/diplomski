public String[] returnArray(int num){
switch(num)
  case 1 : return array1;
  case 2 : return array2;
  .
  .
  .
  case 8 : return array8;
  default : return null //this shouldn't really happen but its required to return something.
}

public void printArray(){
   for(int i=0;i<p.length;i++){
      System.out.print(p[i] + " " );
      for(String s : returnArray(i+1)) System.out.print(s + " ");
      System.out.println();
   }
}