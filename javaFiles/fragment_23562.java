Calendar calendar = Calendar.getInstance();
calendar.set(endingHourInt,Calendar.HOUR);
calendar.set(endingMinInt,Calendaur.MINTUE);
calendar.add(Calendar.HOUR_OF_DAY, 2);
SimpleDateFormat format = new SimpleDateFormat("HH:mm");
format.format(calendar.getTime());