char charValue;
while ((charValue = (char) reader.read()) != -1) {
    if ('\n' == charValue) {
        System.out.println("\\n");              
    }    
    if ('\r' == charValue) {
        System.out.println("\\r");              
    }           
}