try {
    BufferedReader input = new BufferedReader(
            new InputStreamReader(urlConn.getInputStream(), "UTF-8")); 
    StringBuilder strB = new StringBuilder();
    String str;
    while (null != (str = input.readLine())) {
        strB.append(str).append("\r\n"); 
    }
    input.close();
} catch (IOException e) {
    e.printStackTrace();
}