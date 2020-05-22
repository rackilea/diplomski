private static  void convertEdtToLocalTime(String pubDate)
    {
        //pubDate = 12/19/2012 8:57am EST;
        String localPubDate=null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(
                "MM/dd/yyyy HH:mma z");
//          TimeZone timeZone = TimeZone.getDefault(); // No need to do it
//          sdf.setTimeZone(timeZone);
            if (pubDate != null)
            {
                Date date = sdf.parse(pubDate);
                sdf = new SimpleDateFormat("MMM dd yyyy HH:mm");
                localPubDate = sdf.format(date);
            }
        }
        catch (ParseException e)
        {
        }
        System.out.println(localPubDate);
    }