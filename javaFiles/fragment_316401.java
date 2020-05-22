PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOuputStream("filename.txt") "UTF-8"));
pw.println(map.size());
for (Map.Entry<String, String> entry : map.entrySet()) {
     pw.println(encode(entry.getKey()));
     pw.println(encode(entry.getValue()));
}
pw.close();


public static String encode(String s) {
    // if you can assume no new lines, don't do anything.
    return s.replaceAll("\\\\", "\\\\\\\\").replaceAll("\n", "\\\\n");
}