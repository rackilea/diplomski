Calendar cal = Calendar.getInstance();
cal.add(Calendar.HOUR_OF_DAY, 3);

Query q = session.createQuery("from table where date < :date");
q.setCalendarDate("date", cal);
q.list();