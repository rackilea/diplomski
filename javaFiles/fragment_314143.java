SimpleDateFormat inputSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
inputSDF.setTimeZone(TimeZone.getTimeZone("UTC"));
Date myDate = inputSDF.parse("2016-09-25 17:26:12");
//
SimpleDateFormat outputSDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
System.out.println(outputSDF.format(myDate));
System.out.println(TimeZone.getDefault().getID());