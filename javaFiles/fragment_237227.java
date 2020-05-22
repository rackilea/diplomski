if (headers.length != 0) {
    writer = new FileWriter(sFileName);      // Do not append
    // here is the point which will not happen twice, just if i re-run the program
    writer.append(headers);
    writer.append('\n');
} else {
    writer = new FileWriter(sFileName, true); // Append
    // write values to the file
    writer.append(values.toString());
}
writer.flush();
writer.close();