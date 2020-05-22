...
catch (IOException ioex) {
    System.err.println(ioex.getMessage());
} finally {
    try {
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}