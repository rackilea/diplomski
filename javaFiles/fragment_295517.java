try (
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);
) {
    int lineCount = 0;
    String line;

    line = br.readLine();
    if (line != null) {
        String lineParts[] = line.split(" ");
        if (lineParts.length == 2) {
            this.xSize = Integer.parseInt(lineParts[0]);
            this.ySize = Integer.parseInt(lineParts[1]);
            board = new int[this.ySize][this.xSize];
        } else {
            throw new RuntimeException();
        }
        while ((line = br.readLine()) != null) {
            String lineParts[] = line.split(" ");
            lineCount++;
            if (lineParts.length == this.xSize) {
                for (int i = 0; i < this.xSize; i++) {
                    board[lineCount][i] = Integer.parseInt(lineParts[i]);
                }
            } else {
                throw new RuntimeException();
            }
        }
    }
    if (lineCount != this.ySize) throw new RuntimeException();
}