Locale russian = new Locale("ru", "RU");

String dateString = "9 Сентября 2004";
Date jud = new SimpleDateFormat("d MMMM yyyy", russian).parse(dateString);

System.out.println(jud);