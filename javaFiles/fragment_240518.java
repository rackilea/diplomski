Document doc = new Document();
PdfWriter.getInstance(doc, new FileOutputStream(outPath));
[...]
doc.add(p);
[...]
        doc.add(new Paragraph(group));
        doc.add(new Paragraph("\n")); 
[...]
doc.open();
doc.close();