String stringDate="2014-03-20T17:59:03+07:00";//2014-03-20T17:59:03+07:00 2014-03-20T17:59:03-07:00 
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date startDate = sdf.parse(stringDate);
            System.out.println(startDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }