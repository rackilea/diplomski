String dt = "2010-10-22";

SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
ParsePosition ps = new ParsePosition(0)
Date date = sdfIn.parse(dt, pos)

SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

System.out.println(sdfOut.format( date ));