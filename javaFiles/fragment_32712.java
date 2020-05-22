public static void main(String args[]){
    DateTimeFormatter parser = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
    DateTime dt = parser.parseDateTime("2014-10-31T23:59:59");

    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    System.out.println("formatted date is " + formatter.print(dt));
}