String line = null;
int y = 0;
try {
    while ((line = in.readLine())!= null) {
        for (int x = 0; x < line.length(); x++){
            charmap[x][y] = line.charAt(x);
        }
        y++;
    }
} catch (IOException e) {
    e.printStackTrace();
}