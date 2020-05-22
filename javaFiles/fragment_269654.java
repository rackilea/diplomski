String ar2[] = new String[ar1.length]; //better if this is not hard coded to 10
    int x = 0;        
    while(x < ar1.length){
            String[] temp = ar1[x].split(" ");
            ar2[x] = temp[0];
            x++; //Moved in initial edit to fix null printing
     }

     //moved printing code out of loop where populating array occurs 
     for (int i = 0; i < ar2.length; i++){
            System.out.println(ar2[i]);
     }