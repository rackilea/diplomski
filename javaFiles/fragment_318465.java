try {
    SimpleDateFormat sd=new SimpleDateFormat("YYYYMMDDhhmmss");//From FTPClient
    Date date=sd.parse("20140601042221");//Parse String to date
    SimpleDateFormat sd2=new SimpleDateFormat("dd.MM.yyyy HH:mm");
    System.out.println(sd2.format(date));
} catch (ParseException e) {
    e.printStackTrace();
}