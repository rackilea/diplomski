SimpleDateFormat dateofbirthFormat = new SimpleDateFormat("yyyy/MM/dd"); 
    try {
        java.util.Date dateOfBirth = dateofbirthFormat.parse("1986/12/11");
        System.out.println(dateOfBirth);
    } catch (ParseException e) {
    }