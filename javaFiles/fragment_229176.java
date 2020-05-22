import javax.xml.bind.DatatypeConverter;    

byte[] data = DatatypeConverter.parseHexBinary(yourHexString);    
ASN1InputStream s = new ASN1InputStream(new ByteArrayInputStream(data));
ASN1String str = (ASN1String) s.readObject();
System.out.println(str.getString());