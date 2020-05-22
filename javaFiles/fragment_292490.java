System.out.println("datepicker:" +dateimput);



    SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/yyyy"); 
    SimpleDateFormat df2=new SimpleDateFormat("yyyy-MM-dd");
    Date dt=null;
    try {
        dt = df1.parse(dateimput);
        System.out.println("dt" +dt);
        System.out.println("dt formatted" +df2.format(dt));

    } catch (ParseException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }