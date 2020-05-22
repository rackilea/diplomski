String a = new String(
"La Panthère".getBytes(Charset.forName("UTF-8")),
 Charset.forName("Cp1252")
);
System.out.println(a);
System.out.println(
    new String(
        a.getBytes(Charset.forName("Cp1252")), 
        Charset.forName("UTF-8")
    )
);