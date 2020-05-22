Calendar ca = Calendar.getInstance();
    ca.setTime(a);
    ca.set(Calendar.HOUR_OF_DAY, 0);
    ca.set(Calendar.MINUTE, 0);
    ca.set(Calendar.SECOND, 0);
    ca.set(Calendar.MILLISECOND, 0);
    Calendar cb = Calendar.getInstance();
    cb.setTime(b);
    cb.set(Calendar.HOUR_OF_DAY, 0);
    cb.set(Calendar.MINUTE, 0);
    cb.set(Calendar.SECOND, 0);
    cb.set(Calendar.MILLISECOND, 0);

    if (cb.compareTo(ca) ==0 ){
       print True
    }