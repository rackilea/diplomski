String formatIn = "yyyy-MM-dd-HH.mm.ss.SSSSSS";
String formatOut = "yyyy-MM-dd'T'HH:mm:ss.SSSz";

String valueIn = "2016-01-19-09.55.00.000000";

SimpleDateFormat in = new SimpleDateFormat(formatIn);
SimpleDateFormat out = new SimpleDateFormat(formatOut);

Date dateIn = in.parse(valueIn);
System.out.println("< " + dateIn);

String valueOut = out.format(dateIn);
System.out.println("> " + valueOut);