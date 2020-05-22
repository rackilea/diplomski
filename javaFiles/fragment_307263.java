String convertDate="03/19/2014 5:30:10 PM";
         DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.CANADA);
         Date myDate=new Date();
         try {
            myDate=df.parse(convertDate);
            final Calendar c = Calendar.getInstance();
            c.setTime(myDate);
            int y,m,d;
            y=Calendar.YEAR;
            System.out.println("Year = " + c.get(Calendar.YEAR));
            //Log.d("Year", y);
            System.out.println("Month = " + (c.get(Calendar.MONTH)+1));

            System.out.println("Day = " + c.get(Calendar.DATE));
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }