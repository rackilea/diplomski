Date truncateMonth = DateUtils.truncate(input, Calendar.MONTH);
-> DateTime truncateMonth = input.dayOfMonth().roundFloorCopy();

Date truncateMinute = DateUtils.truncate(input, Calendar.MINUTE);
-> DateTime truncateMinute = input.minuteOfDay().roundFloorCopy();

Date truncateHourOfDay = DateUtils.truncate(input, Calendar.HOUR_OF_DAY);
-> DateTime truncateHourOfDay = input.hourOfDay().roundFloorCopy()