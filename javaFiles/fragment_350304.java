final StringBuilder sb = new StringBuilder("");
while (rows.hasNext()) {
    Row row = (Row) rows.next(); 
    // how to write to a semicolon delimited dat file here
    Iterator<Cell> cells = row.cellIterator();

     while (cells.hasNext()) {
        Cell cell = cells.next();
        sb.append(cell.toString()).append(";");
    }
    sb.append("\n");
}   

File file = new File("someFile.dat");

if (!file.exists()) {
    file.createNewFile();
}

FileWriter fw = new FileWriter(file.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);
bw.write(sb.toString());
bw.close();