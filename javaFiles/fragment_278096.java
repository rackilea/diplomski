StringBuilder b64 = new StringBuilder();
try( Reader rdr = new BufferedReader (new FileReader (filename)) ){
    for( String line; (line = rdr.readLine()) != null; )
        if( !line.startsWith ("-----") ) b64.append (line);
        // else optionally check for errors?
} // or use a Stream/filter/collect if you prefer 
byte[] der = Base64.getDecoder().decode(pem);
... CMSEnvelopedDataParser (der) and on from there