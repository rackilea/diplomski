GregorianCalendar date1 = new GregorianCalendar( year, month-1, date );
        SimpleDateFormat dateOnly = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println("Formated date"+dateOnly.format(date1.getTime()));
        String day1="",day2;

    while( date1.get( Calendar.DAY_OF_WEEK ) != Calendar.MONDAY )
        date1.add( Calendar.DATE, 1 );

    da1=String.valueOf(dateOnly.format(date1.getTime()));
    System.out.println("Start_date"+da1);

    date1.add(Calendar.DATE, 6);
    da2=String.valueOf(dateOnly.format(date1.getTime()));
    System.out.println("End_date"+da2);