String test = "176.32.37.27:777754.38.156.202:777751.68.208.5:7777";
System.out.println(
   Arrays.toString(
       test.split("(?<=:\\d{4})")
   )
);