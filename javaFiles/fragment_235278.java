List<int[]> dataSet = new ArrayList<int[]>();
while (inFile.hasNextLine()){
    String line = inFile.nextLine();
    String[] cols = line.split(",");
    int[] row = new int[cols.length];
    for (int i = 0; i < cols.length; i++)
        if (!cols[i].equals("?")) row[i] = Integer.parseInt(cols[i]);
        else row[i] = 0;
    dataSet.add(row);
}