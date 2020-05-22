long millis = -27900000;
javax.xml.datatype.Duration xmlDuration = 
    DatatypeFactory.newInstance().newDuration(millis);
System.out.println("XML: " + xmlDuration.toString()); // -P0Y0M0DT7H45M0.000S
System.out.println(
    String.format(
        "%1$s%2$02d:%3$02d", 
        xmlDuration.getSign() < 0 ? "-" : "+", 
        xmlDuration.getHours(), 
        xmlDuration.getMinutes())); // -07:45