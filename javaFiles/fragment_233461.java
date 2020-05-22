localObject2 = str7 + "/" + str6; // Error 1
 ...
 File localFile2 = new File((String)localObject2); // Error 2
 ...
 localObject1 = Calendar.getInstance(); // Error 4
 localObject2 = new SimpleDateFormat("yyyyMMdd"); // Error 5
 // there's 5 other uses that occurred before it was initialized