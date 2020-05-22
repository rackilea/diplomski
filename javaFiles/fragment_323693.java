String date = "2018-02-21T15:00:00.000+05:30";
  SimpleDateFormat start= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
  SimpleDateFormat start1= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

            try
            {
              Date date1=start.parse(date);
              Date date2=start1.parse(date);
              System.out.println("Date is= " + date1); // Date is = Wed Feb 21 10:00:00 UTC 2018
             System.out.println("Date is= " + date2); // Date is = Wed Feb 21 15:00:00 UTC 2018
            } catch (ParseException e) {
                System.out.println("Exception = " +e);
              }