Calendar calNextSat = Calendar.getInstance();
    calNextSat.set(Calendar.HOUR, 0);
    calNextSat.set(Calendar.MINUTE, 0);
    calNextSat.set(Calendar.SECOND, 0);
    while(calNextSat.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY){
        calNextSat.add(Calendar.DATE, 1);
    }

    System.out.println(calNextSat.getTimeInMillis() - calNow.getTimeInMillis());