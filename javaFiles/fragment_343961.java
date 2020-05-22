FileOutputStream output = new FileOutputStream(filename);
try {
    renderer.createPDF(output);
} finally {
    output.close();
}