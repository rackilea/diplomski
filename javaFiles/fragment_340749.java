CSVReader reader = new CSVReader(isReader, ',', '"', true);
while ((col = reader.readNext()) != null) {
   String c1 = col[1];
   if (null != c1) {
       // ...
   }
}