Calendar calendar = Calendar.getInstance();
int hour = calendar.get(Calendar.HOUR_OF_DAY);
int minute = calendar.get(Calendar.MINUTE);

String directory = "filPath";
String fileName = "snapshot_"+ hour + "_"+ minute +".png";

File dest = new File(directory, fileName);