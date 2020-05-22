String str = "2013-03-27T00:00:00+11:00";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            SimpleDateFormat parseFormatter = new SimpleDateFormat("yyyy-MM-dd");
            //SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss+hh:mm"); 
            Date date = parseFormatter.parse(str);

            String formattedDate = formatter.format(date);
            System.out.println(formattedDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }