Calendar cal = Calendar.getInstance()

      // print current date
      System.out.println("The current date is : " + cal.getTime());

      // add 30 days to the calendar
      cal.add(Calendar.DATE, 30);
      System.out.println("30 days later: " + cal.getTime());


      // add 60 days to the calendar
      cal.add(Calendar.DATE, 30); // already 30 days added
      System.out.println("60 days later: " + cal.getTime());