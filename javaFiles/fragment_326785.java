int height = 7;
for (int i = height; i>=1; i-- ) { //reverse,and change '0' to '1'
  int space_cnt = height - i;  //number of space we need
  for (int j = 1; j <= height ; j++) {
    if(space_cnt-->0){
       System.out.print(" ");      
    }else{
       System.out.print("*");
    }
  }
  System.out.println();
}