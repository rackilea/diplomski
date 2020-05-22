public static boolean isInOverlap(LocalDateTime ldt, DateTimeZone dtz) {
    DateTime dt1 = ldt.toDateTime(dtz).withEarlierOffsetAtOverlap();
    DateTime dt2 = dt1.withLaterOffsetAtOverlap();
    return dt1.getMillis() != dt2.getMillis();
}


public static void test() {
    // CET DST rolls back at 2011-10-30 2:59:59 (+02) to 2011-10-30 2:00:00 (+01)
    final DateTimeZone dtz = DateTimeZone.forID("CET");
    LocalDateTime ldt1 = new LocalDateTime(2011,10,30,1,50,0,0); // not in overlap
    LocalDateTime ldt2 = new LocalDateTime(2011,10,30,2,50,0,0); // in overlap
    System.out.println(ldt1 + " is in overlap? " + isInOverlap(ldt1, dtz)); 
    System.out.println(ldt2 + " is in overlap? " + isInOverlap(ldt2, dtz)); 
}