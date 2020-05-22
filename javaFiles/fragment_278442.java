PdfReader reader = new PdfReader("D:/Eclipse Java/HiltonForms2014_r.pdf");
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(Result));
AcroFields form = stamper.getAcroFields();
form.setField("LASTNAME", rs.getCursorName());
stamper.setFormFlattening(true);
stamper.close();
reader.close();