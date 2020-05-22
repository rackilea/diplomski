cal.set(2013, 1, 0); // 2013-FEB-01 - (1 DAY) = 2013-JAN-31
    cal.get(Calendar.YEAR); // 2013
    cal.get(Calendar.MONTH); // 0 = JAN
    cal.get(Calendar.DAY_OF_MONTH); // 31

    cal.set(2010, 0, 0); // 2010-JAN-01 - (1 DAY) = 2009-DEC-31
    cal.get(Calendar.YEAR); // 2009
    cal.get(Calendar.MONTH); // 11 = DEC
    cal.get(Calendar.DAY_OF_MONTH); // 31