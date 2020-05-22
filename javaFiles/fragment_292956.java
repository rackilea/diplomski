SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
long diff = fmt.parse("30-03-2020 00:00:00").getTime() -
            fmt.parse("1-03-2020 00:00:00").getTime();

System.out.println(diff);
System.out.println("Days: " + TimeUnit.DAYS.convert(Math.abs(diff), TimeUnit.MILLISECONDS));
System.out.println("Hours: " + TimeUnit.HOURS.convert(Math.abs(diff), TimeUnit.MILLISECONDS));
System.out.println("Days: " + TimeUnit.HOURS.convert(Math.abs(diff), TimeUnit.MILLISECONDS) / 24.0);