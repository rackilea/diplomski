<%

    String date1 =request.getParameter("firstdate");

    String date2 =request.getParameter("seconddate");

        SimpleDateFormat dateformat = new SimpleDateFormat ("E yyyy.MM.dd"); //SDF to display output with day of week

    Date displaydate1=new Date(date1); //This fixed everything

    Date displaydate2=new Date(date2);

    int differenceInDays = (int) ((displaydate2.getTime() - displaydate1.getTime())/(1000*60*60*24));//common method to calculate number of days

out.println("Between " +dateformat.format(displaydate1)+ " and " +dateformat.format(displaydate2)+ " there are " +differenceInDays+ " days");

 %>