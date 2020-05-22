for (int k=0;k<lngth;k++)
 {
     if (Character.toString(line.charAt(k)).equals(gss))
     {
         upd=upd.substring(0,k)+gss+upd.substring(k+1);
         c++; 
     }
 }