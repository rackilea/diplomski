List<String> lineas = new ArrayList<String>();
BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(
                                "C:\\Personal\\temp\\ffffff.txt"), "ISO-8859-3"));
try {
    for (String s; (s = in.readLine()) != null; ) {
        lineas.add(s);
    }
} finally {
    in.close();
}