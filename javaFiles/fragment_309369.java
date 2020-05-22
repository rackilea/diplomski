JFormattedTextField jFormattedTextField1;
MaskFormatter mf;

mf = new MaskFormatter("** ****** ****");
mf.setValidCharacters("0123456789 ");
jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(mf));