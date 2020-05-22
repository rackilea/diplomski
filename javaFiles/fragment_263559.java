for(i=0;i<multTable.length;i++){
     int mult = constant*i;
     if(mult!=multTable[i]) {
         return false;
     }
 }
 return true;