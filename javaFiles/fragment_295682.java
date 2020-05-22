final String dateString = "16-08-2015 16:15:16";
final long millisToAdd = 7_200_000; //two hours

DateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

Date d = format.parse(dateString);
d.setTime(d.getTime() + millisToAdd);

System.out.println("New value: " + d); //New value: Sun Aug 16 18:15:16 CEST 2015