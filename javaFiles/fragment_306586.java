//Thu, 27 Sep 2012 13:44:09 +0000
SimpleDateFormat dfDb = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
Date dateDb = dfDb.parse(yourStringDateFromDb);
                                               //27/09/2012 13:44:09
SimpleDateFormat toYours = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
String yourString = toYours.format(dateDb);