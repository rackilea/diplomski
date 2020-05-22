StringBuilder all_lines = new StringBuilder(); //To store every line

for (int i = 0; i < some_condition; i++) {
    StringBuilder line = new StringBuilder();
    for (String record: aLine) {
        line.append(record).append(" ");       //To store every words
    }
    all_lines.append(line.toString().trim());
    all_lines.append("\n");
}

outFile.write(all_lines.toString().trim());
outFile.close();