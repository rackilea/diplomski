try {
    File file =  new File(i);
    img = ImageIO.read(file);
} catch (Exception ex) {
    // You probably want to open the java console, or use a logger
    // as a JNLP may send stderr someplace weird.
    Systemm.err.println("Exception was: ", ex.toString());
}