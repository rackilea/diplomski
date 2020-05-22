String postData1 = "username=johndoe&password=mypassword";
 String postData2 = "username="+user+"&password="+pass;
 char[] arr1 = postData1.toCharArray();
 char[] arr2 = postData1.toCharArray();

 for (int i=0; i< Math.max(arr1.length(), arr2.length(); i++ ) {
     if(arr1[i] != arr2[i]) {
         System.out.println("Different i " + i);
     } 
 }