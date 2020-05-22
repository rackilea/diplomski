Calendar cal = Calendar.getInstance(); 
    cal.set(Calendar.MINUTE, 0); 
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    cal.set(Calendar.HOUR_OF_DAY, 9);
    if (datetime < cal.getTimeInMillis()) {
        return false;
    }
    cal.set(Calendar.HOUR_OF_DAY, 20); 
    return datetime <= cal.getTimeInMillis();