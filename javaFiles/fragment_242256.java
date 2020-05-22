String[] array1={"Hello","Hi"};
String[] array2={"Hello","eat"};

for(int x=0;x<array1.length;x++){
    Boolean present=false;
    for(int y=0;y<array2.length;y++){
       if(array1[x].equals(array2[y])){
         present=true;
         break;
       }
     }
   if(!present){
      System.out.println(array1[x]);
 }
}