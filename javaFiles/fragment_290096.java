//Create a date formatter.
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'LLL'Z'");
//Create a date object for today's date.
        Date currentDate=new Date();
//Create a string for the date from parse.
        String parseTime = singleClaim.getString("updatedAt");
//Create a string for the current date.
        String currentTime=currentDate.toString();
//Initialize the date object for the updatedAt time on Parse.
        Date parseDate = null;
        try {
//Here, we convert the parseTime string into a date object and format it.
            parseDate = formatter.parse(parseTime);
} 

        catch (Exception e) {
            e.printStackTrace();
        }           

   //Get the time difference from the current date versus the date on Parse.
        long difference = currentDate.getTime()-parseDate.getTime();