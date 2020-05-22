int[][] worldMap = new int[256][256]; //generated via GUI
File file = new File(fileName);
BufferedWriter br = new BufferedWriter(new FileWriter(file));

//writing header

for (int dy = 0; dy < 256; dy++) {
    br.write("    public static int row_"+dy+"(int x){\n");
    br.write("        switch (x) {\n");
    for (int dx = 0; dx < 256; dx++) {
        br.write("        case " + dx + ": return " + worldMap[dx][dy] + ";\n");
    }
    br.write("        default: return 0;\n");
    br.write("        }\n");
    br.write("    }\n");
    br.write("\n");
}

//writing trailer