try {
   ...
catch (IOException e) {
    e.printStackTrace(); // add me
} finally {
    in.close();
    out.flush();
    out.close();
}