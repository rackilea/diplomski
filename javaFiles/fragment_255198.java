BufferedReader csvFile = new BufferedReader(
        new InputStreamReader(inputStream));

   while ((csvLine = csvFile.readLine()) != null) {
        if (csvLine.charAt(0) == '#') {
             // do # data action here
        }
   }