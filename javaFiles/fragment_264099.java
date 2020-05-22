Calendar calendar=Calendar.getInstance();
int day=calendar.get(Calendar.DAY_OF_MONTH);
SimpleDateFormat sdf;
if(day>9){
  sdf = new SimpleDateFormat("MMM dd HH:mm:ss");
}else{
  sdf = new SimpleDateFormat("MMM  d HH:mm:ss");
}
System.out.println(sdf.format(new Date()));