String d1 = "21:00:00";
    String d2 = "04:00:00";
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String dToTest = "16:00:00";
    boolean isSplit = false, isWithin = false;

    Date dt1 = null, dt2 = null,  dt3 = null;

    dt1 = sdf.parse(d1);
    dt2 = sdf.parse(d2);
    dt3 = sdf.parse(dToTest);

    isSplit = (dt2.compareTo(dt1) < 0);
    System.out.println("[split]: " +isSplit);

    if (isSplit)
    {
        isWithin = (dt3.after(dt1) || dt3.before(dt2));
    }
    else
    {
        isWithin = (dt3.after(dt1) && dt3.before(dt2));
    }

    System.out.println("Is time within interval? " +isWithin);