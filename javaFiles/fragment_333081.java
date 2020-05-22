public static String[][] read() throws IOException {
  BufferedReader br = new BufferedReader(new FileReader("D:/College/Java Eclipse/Map.txt"));
  int columnCount = Integer.parseInt(br.readLine());
  int rowCount = Integer.parseInt(br.readLine());
  String[][] map = new String[rowCount][columnCount];

  for (int i = 0; i < rowCount; i++) {
    String line = br.readLine();

    for (int j = 0; j < columnCount; j++) {
      map[i][j] = String.valueOf(line.charAt(j));
    }
  }
  br.close();
  //System.out.println(Arrays.deepToString(map));
  return map;
}