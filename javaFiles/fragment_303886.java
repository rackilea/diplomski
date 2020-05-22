public void readMap(String fileName) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    int lines = 0, columns = 0;
    String str;
    List<String> lineList = new ArrayList<>();
    while ((str = br.readLine()) != null && str.length() != 0) {
        lines++;
        columns = Math.max(columns, str.length()); // as it's not fixed
        lineList.add(str);
    }
    System.out.println("Row : " + lines);
    System.out.println("Columns : " + columns);

    char[][] map = new char[lines][columns];
    for (int i = 0; i < lines; i++) {
        String currentLine = lineList.get(i);
        int idx = 0;
        for (int j = 0; j < currentLine.length(); j++) {
            map[i][j] = currentLine.charAt(idx++);
        }
    }
    for (int r = 0; r < map.length; r++) {
        for (int c = 0; c < (map[0].length); c++) {
            System.out.print(map[r][c]);
        }
        System.out.println();
    }
}