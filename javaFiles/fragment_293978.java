long input = 20120720162145L;

DateFormat inputDF = new SimpleDateFormat("yyyyMMddHHmmss");
DateFormat outputDF = new SimpleDateFormat("yyyy-MM-dd K:mm a");

Date date = inputDF.parse(""+input);

System.out.println(outputDF.format(date));