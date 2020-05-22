Scanner k = new Scanner(System.in);
System.out.println("Size: ");
String s = k.nextLine();
s.toUpperCase();

int Xindex = s.indexOf('x');
int x = Integer.parseInt(s.substring(0, Xindex));
int y = Integer.parseInt(s.substring(Xindex + 1));

System.out.println("Matrix:");
char[][] matrix = new char[x][y];

for (int i = 0; i < x; i++) {
    for (int p = 0; p < y; p++) {
        matrix[i][p] = k.next().charAt(0);
    }
}

System.out.print("Word: ");
String word = k.next();

int xStart = -1, yStart = -1;
int xEnd = -1, yEnd = -1;

// looping through the matrix
for (int i = 0; i < x; i++) {
    for (int j = 0; j < y; j++) {
        // when a match is found at the first character of the word
        if (matrix[i][j] == word.charAt(0)) {
            int tempxStart = i;
            int tempyStart = j;
            // calculating all the 8 normals in the x and y direction
            // (the 8 different directions from each cell)
            for (int normalX = -1; normalX <= 1; normalX++) {
                for (int normalY = -1; normalY <= 1; normalY++) {
                    // go in the given direction for the whole length of
                    // the word
                    for (int wordPosition = 0; wordPosition < word
                            .length(); wordPosition++) {
                        // calculate the new (x,y)-position in the
                        // matrix
                        int xPosition = i + normalX * wordPosition;
                        int yPosition = j + normalY * wordPosition;
                        // if the (x,y)-pos is inside the matrix and the
                        // (x,y)-vector normal is not (0,0) since we
                        // dont want to check the same cell over again
                        if (xPosition >= 0 && xPosition < x
                                && yPosition >= 0 && yPosition < y
                                && (normalX != 0 || normalY != 0)) {
                            // if the character in the word is not equal
                            // to the (x,y)-cell break out of the loop
                            if (matrix[xPosition][yPosition] != word
                                    .charAt(wordPosition))
                                break;
                            // if the last character in the word is
                            // equivalent to the (x,y)-cell we have
                            // found a full word-match.
                            else if (matrix[xPosition][yPosition] == word
                                    .charAt(wordPosition)
                                    && wordPosition == word.length() - 1) {
                                xStart = tempxStart;
                                yStart = tempyStart;
                                xEnd = xPosition;
                                yEnd = yPosition;
                            }
                        } else
                            break;
                    }
                }
            }
        }
    }
}
System.out.println("(" + xStart + "," + yStart + ")(" + xEnd + ","
        + yEnd + ")");
k.close();