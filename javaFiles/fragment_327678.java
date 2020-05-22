Scanner s = new Scanner(new File("data.txt"));
 while (s.hasNextLine()) {
      String line = s.nextLine();
      String[] items= line.split("\t", -1);
      System.out.println(items[5]);
      //System.out.println(Arrays.toString(cols));
 }