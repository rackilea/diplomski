stripper.setStartPage( 1 );
stripper.setEndPage( 1);
Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
stripper.writeText(document, dummy);
String qoute_number = lines.get(2);
System.out.println(qoute_number);

lines.clear();

stripper.setStartPage( 3 );
stripper.setEndPage( 3);