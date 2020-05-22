int i = 0;
 BufferedReader buffy = new BufferedReader(new FileReader(fileName));
 while((str = buffy.readLine()) != null) {
    if(i < arrayInt.length) {
       int k = str.indexOf(" ");
       if(k!=-1) {
          String nums = str.substring(k+1);
          arrayInt[i] = Integer.parseInt(nums);
       }
       i++;
    }
 }
 buffy.close();