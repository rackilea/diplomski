Date date = new Date();
Calendar cal = Calendar.getInstance();
cal.setTime( date );
cal.set( Calendar.HOUR_OF_DAY, 20 );
cal.set( Calendar.MINUTE, 15 );
cal.set( Calendar.SECOND, 0 );
cal.set( Calendar.MILLISECOND, 0 );
cal.add( Calendar.MINUTE, 22 );
date = cal.getTime();