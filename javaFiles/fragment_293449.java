Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.MONTH, monthOfYear);
sdf  = new SimpleDateFormat("LLL", Locale.getDefault()).format(calendar.getTime());

 or

sdf = new DateFormatSymbols().getShortMonths()[monthOfYear];