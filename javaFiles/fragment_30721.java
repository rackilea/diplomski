Query query = session.createQuery("select la from LoginActivity la where la.dateLastUpdated > :date");
Calendar cal = Calendar.getInstance();
cal.add(Calendar.HOUR, -12);
Date date = cal.getTime();
query.setParameter("date", date);
List result = query.list();