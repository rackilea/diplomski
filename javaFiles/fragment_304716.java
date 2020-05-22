[...]
ArrayList result = new ArrayList<int[]>();
line = read.readLine();
do {
  readData = line.split(" ");
  int[] row = new int[readData.length];
  for(int i = 0; i < readData.length; i++) {
    row[i] = Integer.parseInt(readData[i]);
  }
  result.add(row);
} while (line != null);