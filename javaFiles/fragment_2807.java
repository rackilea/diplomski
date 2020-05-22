int i = 0;
 BufferedReader buffy = new BufferedReader(new FileReader(fileName));
 while((str = buffy.readLine()) != null) {
    if(i < arrayInt.length) {
       for(int k = 0; k <= str.length()-1; k++) {
          if(str.substring(k, k + 1).equals(" ")) {
             String nums = str.substring(k+1);
             arrayInt[i] = Integer.parseInt(nums);
             break;
          }
       }
       i++;
    }
 }
 buffy.close();