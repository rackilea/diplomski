OutputStream out = new FileOutputStream("C:\\Temp\\filename.dat");
try {
    // Write data to 'out'
} finally {
    // Make sure to close the file when done
    out.close();
}