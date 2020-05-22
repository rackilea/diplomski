public static void main(String[] args) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String date="2012-10-03T22:00:00.000+0000";
        try {
            System.out.println(dateTimeFormat.getTimeZone().getDisplayName());
            System.out.println("Today : "+new Date().toString()+ ", Timezone Offset :" +
                    +(new Date()).getTimezoneOffset());
            System.out.println("Parsed Date : "+
                    dateTimeFormat.parse(date).toString()
                    + ", Timezone Offset : "
                    +dateTimeFormat.parse(date).getTimezoneOffset());           
        } catch (ParseException e) {            
            e.printStackTrace();
        }
    }