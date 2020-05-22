for (int a = 0; a < list.size(); a++){
     int range1 = 1;
     int range2 = 10;
     for (int b = 0; b < list.size(); b++){
       if (list.get(b) >= range1 && list.get(b) <= range2)
           Array[a] += 1;
     }  
     range1 += 10;
     range2 += 10;  
 }