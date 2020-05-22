String date = "05/09/13 10.55 PM";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh.mm a");
        Date testDate = null;

        try {
            testDate = sdf.parse(date);
            // Add 1 hour logic
            Calendar tmpCalendar = new GregorianCalendar(); 
            tmpCalendar.setTime(testDate); 
            tmpCalendar.add(Calendar.HOUR_OF_DAY, 1);           
            testDate = tmpCalendar.getTime();           

            // Continue with your logic
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
            String newFormat = formatter.format(testDate);
            System.out.println(".....Date..." + newFormat);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }