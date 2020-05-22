...
long javaTime = new Date().getTime();
long nanoTime = System.nanoTime();
long newtimestamp = javaTime * 1000000 +            // Compute the timestamp
            (event.timestamp - nanoTime);           // in nanos first
String longStr = Long.valueOf(newtimestamp).toString();
String tsString = longStr.substring(0, longStr.length()-6) +// Format the output string
            "." + longStr.substring(longStr.length()-6);    // to have the comma in the
                                                            // correct space.
...