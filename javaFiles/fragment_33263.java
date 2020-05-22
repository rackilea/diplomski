public String toString(){
   String  str = "name : "+name;
   for(int i=0;i<grades.length;i++){
     str += grades[i] + " ";
   }
   return str;
}