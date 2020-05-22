DateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
dateFormat.setTimeZone(TimeZone.getTimeZone("UTC")); // <-- Add this.
Date hora=dateFormat.parse("00:00:01");
System.out.println(hora.getHours()+" "+hora.getMinutes());
System.out.println("Date "+hora);
System.out.println("Seconds "+TimeUnit.MILLISECONDS.toSeconds(hora.getTime()));