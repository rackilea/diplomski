in.setTimeZone(TimeZone.getTimeZone("GMT"));
dateIn = in.parse(valueIn);
System.out.println("< " + dateIn);

out.setTimeZone(TimeZone.getTimeZone("GMT"));
valueOut = out.format(dateIn);
System.out.println("> " + valueOut);