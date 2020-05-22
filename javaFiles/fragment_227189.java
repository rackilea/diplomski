while (reader.readLine() != null) {
    String read = reader.readLine();// bufferedreader string variable
    String[] rawRow = read.split(",");
    String lastEntry = rawRow[rawRow.length - 1]; // this contains Member No/branchno
    String[] properLastEntry = lastEntry.split("/"); // this contains Member No, branchno as entries

    // create a memory which can contain rawRow and properLastEntry in a single
    // array
    String[] oneRow = new String[rawRow.length - 1 + properLastEntry.length];
    // copy the data for the finalRow
    System.arraycopy(rawRow, 0, oneRow, 0, rawRow.length - 1);
    System.arraycopy(properLastEntry, 0, oneRow, oneRow.length - properLastEntry.length,
            properLastEntry.length);
}