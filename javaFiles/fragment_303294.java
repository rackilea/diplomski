Calendar c = Calendar.getInstance();
c.clear(); // To reset all fields
c.set(Calendar.HOUR_OF_DAY, 23);
c.set(Calendar.MINUTE, 0);
c.set(Calendar.SECOND, 5);

c.add(Calendar.SECOND, -1);