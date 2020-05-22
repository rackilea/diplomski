void addAnnotation(PdfAnnotation annot, int page) {
-     annot.setPage(page);
+        if (annot.isAnnotation())
+            annot.setPage(page);
         addAnnotation(annot, reader.getPageN(page));
     }