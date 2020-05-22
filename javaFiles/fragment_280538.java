String dateString = "15th July, 2014";
    dateString= dateString.replace("th", "").replace("nd", "").replace("rd", "").replace("st", "");

    SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMMM, yyyy");
    Date dt = formatter1.parse(dateString);

    SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
    System.out.println(formatter2.format(dt));