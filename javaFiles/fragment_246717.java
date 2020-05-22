char[] buffer = new char[4096];
   int n = reader.read(buffer);
   while (n != -1) {
       xhtml.characters(buffer, 0, n);
       n = reader.read(buffer);
   }