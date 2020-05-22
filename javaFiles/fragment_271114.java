SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");  
try {  
    Date date = format.parse(dtStart.replaceAll("Z$", "+0000"));  
    System.out.println(date);  
} catch (ParseException e) {  
    // TODO Auto-generated catch block  
    e.printStackTrace();  
}