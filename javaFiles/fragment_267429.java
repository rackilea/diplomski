javafx.util.Duration.valueOf("PT10M");

Exception in thread "main" java.lang.NumberFormatException: empty String
    at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1842)
    at sun.misc.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
    at java.lang.Double.parseDouble(Double.java:538)
    at javafx.util.Duration.valueOf(Duration.java:85)