public AsciiArt(String filename, int nrRow, int nrCol){
    this.nrRow = nrRow;
    this.nrCol = nrCol;
    image = new char[nrRow][nrCol];

    try{
        Scanner input = new Scanner(new File(filename));

        int row = 0;
        int column = 0;

        while(input.hasNext()){
            String c = input.next();
            image[row][column] = c.charAt(0);

            column++;

            // handle when to go to next row
        }   

        input.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
        // handle it
    }
}