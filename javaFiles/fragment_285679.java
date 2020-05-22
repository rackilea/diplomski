String input = "11/1/2010";

SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/d/yyyy");
Date date = simpleDateFormat.parse(input);
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
boolean isWeekday = dayOfWeek >= 2 && dayOfWeek <= 6;
System.out.println(isWeekday);