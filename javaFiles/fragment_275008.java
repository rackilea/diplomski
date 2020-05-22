String sCreatedDate = "30.07.201514:57:03";
String sModifiedDate = "30.07.201515:40:34";            
SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyyHH:mm:ss");//mm small
Date d1 = parser.parse(sCreatedDate);
Date d2 = parser.parse(sModifiedDate);         
System.out.println(d1.before(d2));//true