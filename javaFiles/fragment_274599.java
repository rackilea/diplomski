private String[] validate(HttpServletRequest request,String Number,String Date) {
 ..
 //Add the Number, Date to the array
 values[0]=Number;//array index can be anything you like(you can add them to the end of the array)
 values[1]=Date;
 ..
 return values;  //This is returning values..
 }