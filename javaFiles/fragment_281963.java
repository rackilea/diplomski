//for HTML documents.
DocumentFormat html = new DocumentFormat("HTML", DocumentFamily.TEXT, "text/html", "html");
html.setExportFilter(DocumentFamily.TEXT, "HTML (StarWriter)");
//for .doc documents.        
DocumentFormat doc = new DocumentFormat("Microsoft Word", DocumentFamily.TEXT, "application/msword", "doc");
doc.setExportFilter(DocumentFamily.TEXT, "MS Word 97");