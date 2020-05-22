rea.mark(4048); // Set mark at beginning of file    
if (rea.readLine() == null) {
    for (int i = 1; i < 6; i++) {
        writ.write("Player" + i + "\t\t" + "99:99");
        writ.newLine();
    }
    writ.close();
    rea.reset();
}