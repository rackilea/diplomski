String str;
char[][] m = new char[16][16];
int col = 0;
while((s = in.readLine()) != null) {
    char[] row = s.toCharArray();
    for (int i = 0; i < 16; i++) {
        m[col][i] = row[i];
    }
    col++;
}
in.close();