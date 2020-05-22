Calendar cal = Calendar.getInstance();
String input = String.valueOf(inputDate);
cal.set(Calendar.YEAR, Integer.valueOf(input.substring(0, 4)));
cal.set(Calendar.MONTH, Integer.valueOf(input.substring(4, 6)) - 1);
cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(input.substring(6)));
Date date = cal.getTime();