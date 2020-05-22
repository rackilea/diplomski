
   br = new BufferedReader(new FileReader(csvFile));
   int row = 0;
   while ((line = br.readLine()) != null) {
    String characterload[] = line.split(cvsSplitBy);
    int intDeckerProgram = Integer.parseInt(characterload[1]);
      Character[row][1] = intDeckerProgram;
      row++;
   }