String[] myData = line.split(" ");

if(myData[0].equals("DATE") && flag == 0){

    flag = 1;

   }
   else if(myData[0].equals("DATE") && flag == 1){

    n = n + 1;
    flag = 0;

   }