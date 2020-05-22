LocalDateTime formatOrderEndDateTime;
try {
     DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
     formatOrderEndDateTime = LocalDateTime.parse(line.trim(), formatter);

     DateTimeFormatter f2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
     System.out.println(formatOrderEndDateTime.format( f2 ));
} catch (Exception e) {
     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
}