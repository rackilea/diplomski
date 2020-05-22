String parts[][] = { { "25", "3", "18" }, { "20", "12", "18" }, { "1", "1", "15" } };

int[][] stringToInt = new int[parts.length][parts[0].length];

for (int a = 0; a < parts.length; a++) {
    for (int b = 0; b < parts[0].length; b++) {
        stringToInt[a][b] = Integer.parseInt(parts[a][b]);
    }
}