long currentTime = System.currentTimeMillis();
long plus47Hours = currentTime + (47 * 60 * 60 * 1000);
Timestamp plus47HoursTS = new Timestamp(plus47Hours);

long plus48Hours = currentTime + (48 * 60 * 60 * 1000);
Timestamp plus48HoursTS = new Timestamp(plus48Hours);

Query query = session.createQuery("from GroupNotes as gn where gn.zugwisenPersonId!=:val and gn.timeToend > :from and gn.timeToend < :to");
query.setParameter("from", plus47HoursTS);
query.setParameter("to", plus48HoursTS);