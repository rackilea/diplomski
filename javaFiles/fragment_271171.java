SimpleDateFormat parser= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
java.util.Date d = null;

try {
    d = parser.parse(str);
            System.out.println("Parsed date is "+d);
} catch (java.text.ParseException e) {
    e.printStackTrace();
}