DateFormat Formatter=null;
        Date convertedDate=null;
        Formatter=new SimpleDateFormat("DD-MMM-YYYY",Locale.ENGLISH);
        try {
            convertedDate=(Date)Formatter.parse(date);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        java.sql.Date sqlDate=new java.sql.Date(convertedDate.getTime());
        System.out.println(date);
        System.out.println(convertedDate);