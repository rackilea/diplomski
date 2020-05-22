hour = new Date();
Calendar cal = Calendar.getInstance();

while(hour < hourEnd){
   cal.setTime(hour);
   cal.add(Calendar.MINUTE, 15);
   hour = cal.getTime();
}