public static void main(String[] args) throws ParseException {
        String str_date="2014-09-24T21:32:39-04:00";
        str_date = str_date.replaceAll(":(\\d\\d)$", "$1");
        System.out.println("Input modified according to Java 6: "+str_date);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date date = (Date)formatter.parse(str_date);
        System.out.println(date);
    }