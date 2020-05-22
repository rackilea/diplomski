try {
        SimpleDateFormat sdf= new SimpleDateFormat("MM-dd-yy");
        Date d = sdf.parse("05-19-1990");
        System.out.println(sdf.format(d));
    } catch (ParseException ex) {
       ex.printStackTrace();
    }