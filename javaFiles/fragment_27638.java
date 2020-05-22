Well you can use parser, and xml schema to define the length of the required variables that way one can extract the required varaibles. But yes, those variables will have predefined length.
    String data= "samsungA500";
    String schema = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
                    "<!-- DTD can be pulled from the Jar or over the web -->\r\n" + 
                    "<!DOCTYPE PZMAP SYSTEM  \"flatpack.dtd\" >\r\n" + 
                    "<!--<!DOCTYPE PZMAP SYSTEM \"http://flatpack.sourceforge.net/flatpack.dtd\"> -->\r\n" + 
                    "<PZMAP>\r\n" + 
                    "   <COLUMN name=\"std_name\" length=\"9\" />\r\n" + 
                    "   <COLUMN name=\"std_price\" length=\"3\" />\r\n" +  
                    "</PZMAP>";

InputStream mapping = new ByteArrayInputStream(schema.getBytes());
        InputStream dataStream = new ByteArrayInputStream(data.getBytes());    
Parser pzparser = DefaultParserFactory.getInstance().newFixedLengthParser(mapping, dataStream);
            DataSet ds = pzparser.parse();
while (ds.next()) {
                System.out.println(ds.getString("std_name"));
                System.out.println(ds.getInt("std_price"));
                System.out.println(ds.getString("std_name"));
            }