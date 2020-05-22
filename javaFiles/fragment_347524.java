SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date date1 = sdf.parse("2009-12-31");
Date date2 = sdf.parse("2010-01-31");

if(date1.compareTo(date2)>0){
    System.out.println("Date1 is after Date2");
}else if(date1.compareTo(date2)<0){
    System.out.println("Date1 is before Date2");
}else if(date1.compareTo(date2)==0){
    System.out.println("Date1 is equal to Date2");
}else{
    System.out.println("How to get here?");
}