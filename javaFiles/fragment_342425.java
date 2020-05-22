//create a StringWriter for the output
StringWriter outWriter = new StringWriter();
StreamResult result = new StreamResult( outWriter );
...
transformer.transform( source, result );  
StringBuffer sb = outWriter.getBuffer(); 
String finalstring = sb.toString();