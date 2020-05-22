URL url = new URL("http:www.futureretrogaming.tk/gamefiles/ProfessorPhys");
InputStream is = null;
try {
    is = url.openStream();
    byte[] buffer = new byte[1024];
    int bytesRead = -1;
    StringBuilder page = new StringBuilder(1024);
    while ((bytesRead = is.read(buffer)) != -1) {
        page.append(new String(buffer, 0, bytesRead));
    }
    // Spend the rest of your life using String methods
    // to parse the result...
} catch (IOException ex) {
    ex.printStackTrace();
} finally {
    try {
        is.close();
    } catch (Exception e) {
    }
}