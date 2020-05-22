//i've removed the decimal digits from your number and added the L for long casting
Date itemDate = new Date(1500322822L * 1000);
//or alternatively you can do 
//Date itemDate = new Date((long)1500322822 * 1000);
String text = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a").format(itemDate);
//text is now "17-07-2017 08:20:22 PM"