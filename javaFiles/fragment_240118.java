writer.print ("GET " + szUrl + " HTTP/1.0\r\n"); 
writer.print ("header1: value1\r\n"); 
writer.print ("header2: value2\r\n"); 
writer.print ("header3: value3\r\n"); 
// end the header section
writer.print ("\r\n");