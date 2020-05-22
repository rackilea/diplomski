Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0);

Date fromDate = cal.getTime();

cal.set(Calendar.HOUR_OF_DAY, 23);
cal.set(Calendar.MINUTE, 59);
cal.set(Calendar.SECOND, 59);

Date toDate = cal.getTime();

Query loadSource = session_source.createQuery("select blablabla FROM SwitcherServiceSource" +
        " where TIMESTAMP between :awal and :akhir " +
        " and blablabla group by blabla order by blablabla");
loadSource.setParameter("awal", fromDate );
loadSource.setParameter("akhir", toDate);