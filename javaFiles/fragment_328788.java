public static void loadGame() throws Exception {
    //deserialization

    FileReader fileReader = new FileReader(filename);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    structurePack.Board.gameBoard[0][0] = Integer.parseInt(bufferedReader.readLine());
    structurePack.Board.gameBoard[0][1] = Integer.parseInt(bufferedReader.readLine());
    structurePack.Board.gameBoard[0][2] = Integer.parseInt(bufferedReader.readLine());
    structurePack.Board.gameBoard[1][0] = Integer.parseInt(bufferedReader.readLine());
    structurePack.Board.gameBoard[1][1] = Integer.parseInt(bufferedReader.readLine());
    structurePack.Board.gameBoard[1][2] = Integer.parseInt(bufferedReader.readLine());
    structurePack.Board.gameBoard[2][0] = Integer.parseInt(bufferedReader.readLine());
    structurePack.Board.gameBoard[2][1] = Integer.parseInt(bufferedReader.readLine());
    structurePack.Board.gameBoard[2][2] = Integer.parseInt(bufferedReader.readLine());
}