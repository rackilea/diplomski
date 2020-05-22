String key = "string";
int row = 2;
int col = 128;
int[][] fullKey = new int[row][col];
int counter=0;

for (int i = 0; i < col; i++) {
    fullKey[0][i] = key.charAt(counter);
    counter = (counter==key.length()-1) ? 0 : (counter+1);
}