String input_date_string="2015-02-24";
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = dateformat.parse(input_date_string);
            DateFormat dayFormate=new SimpleDateFormat("EEEE"); 
            String dayFromDate=dayFormate.format(date);
            Log.d("asd", "----------:: "+dayFromDate);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }