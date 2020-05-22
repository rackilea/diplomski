StringBuilder sb = new StringBuilder();
try(BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
    String line = null;
    while ((line = reader.readLine()) != null) {
        sb.append(line.trim());
    }
}
System.out.println(sb.toString());