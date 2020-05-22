Calendar currentDate = Calendar.getInstance();
Calendar anotherDate = Calendar.getInstance();
Date convDate = new SimpleDateFormat("dd-MMM-yyyy").parse("20-Aug-2013");
anotherDate.setTime(convDate);
if(currentDate .after(anotherDate) || 
   currentDate .equals(anotherDate)){
    System.out.println("Correct");
}else{
   System.out.println("In correct");
}