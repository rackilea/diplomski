public static void parseToCSV() throws IOException {
    List<String> list = generateList();
    List<String> unitList = Arrays.asList("g", "kg","ml","l");          
    List<String> quantityList = Arrays.asList("Full", "Quarter", "Half", "3 Quarter", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0");                                                                                                   

    for(String s : list) {
      String[] strArr = s.split(" ");
      // Checks if the String array is too short for what we need(i.e "8g carrots" instead of "8 g carrots")
      if(strArr.length == 2) {
        String newStr = rewriteString(strArr, quantityList);
        strArr = newStr.split(" ");
      }
      String[] itemLine = new String[3];
      for(int i = 0; i < strArr.length; i++) {
        String str = strArr[i];
        int index = findValueLocation(str, quantityList, unitList);
        itemLine[index] = str;
      }
      String line = createLineForCSV(itemLine);
      writeToFile(line);
    }

  }

  private static List<String> generateList() {
    List<String> list = new ArrayList<>();
    String inputOne = "1 kg potatoes";
    String inputTwo = "3 g juice";
    String inputThree = "8g carrots";
    list.add(inputOne);
    list.add(inputTwo);
    list.add(inputThree);
    return list;
  }

  /**
   * Return the index where the value should go in a comma separated String. If the
   * value is not found in either list then it is the item by default.
   */
  private static int findValueLocation(String str, List<String> quantityList, List<String> unitList) {                                                                                                 

    for(String quantity : quantityList) {
      if(quantity.equals(str)) {
        return 0;
      }
    }
    for(String unit : unitList) {
      if(unit.equals(str)) {
        return 1;
      }
    }
    return 2;
  }

  private static String createLineForCSV(String[] itemLine) {
    StringBuilder sb = new StringBuilder();
    sb.append(itemLine[0]).append(",");
    sb.append(itemLine[1]).append(",");
    sb.append(itemLine[2]);
    return sb.toString();
  }

  private static void writeToFile(String line) throws IOException {
    // Set to true for append mode
    BufferedWriter writer = new BufferedWriter(new FileWriter("csv_file.csv", true));
    writer.write(line);
    writer.newLine();
    writer.close();
  }