Path csvFile = Paths.get("D:/input.csv");
try (BufferedReader br = Files.newBufferedReader(csvFile, StandardCharsets.ISO_8859_1)) {

     String line;
     while ((line = br.readLine()) != null) {
         int[] b = lineToInts(line);
         int n = b.length; 

         // Sum while reading:
         int sum = 0;
         for (int i = 0; i < 7; ++i) {
             sum += b[i];
         }
         System.out.print(sum + " ");

         sum = 0;
         for (int i = n - 5; i < n; ++i) {
             sum += b[i];
         }
         System.out.print(sum + " ");

         System.out.println();
     }
}

private static int[] lineToInts(String line) {
     // Using split is slow, one could optimize the implementation.
     String[] a = line.split(";", -1);
     int[] b = new int[a.length]; 
     for (int n = 0, n < a.length(), n++){
         b[n] = Integer.parseInt(a[n]);
     }
     return b;
}