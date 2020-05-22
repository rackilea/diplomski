Calendar c = Calendar.getInstance(); //now

    Calendar m = Calendar.getInstance(); //midnight
    m.set(Calendar.HOUR_OF_DAY, 0);
    m.set(Calendar.MINUTE, 0);
    m.set(Calendar.SECOND, 0);
    m.set(Calendar.MILLISECOND, 0);

    int diff = (int) (c.getTimeInMillis() - m.getTimeInMillis()) ;
    int v = diff / 10;

    byte[] bytes = new byte[4];
    bytes[0] = (byte) ((v >>> 24) & 0xFF);
    bytes[1] = (byte) ((v >>> 16) & 0xFF);
    bytes[2] = (byte) ((v >>>  8) & 0xFF);
    bytes[4] = (byte) ((v >>>  0) & 0xFF);