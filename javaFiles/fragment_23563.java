DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
Date date = new Date();

String[] dateArr = dateFormat.format(today).split("\\.");

int currentnDay = Integer.parseInt(dateArr[0]);
int currentMonth = Integer.parseInt(dateArr[1]);
int currentYear = Integer.parseInt(dateArr[2]);