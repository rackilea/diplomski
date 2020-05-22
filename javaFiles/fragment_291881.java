private static HashMap<String, String[]> populateSynonymMap() {
    HashMap<String, String[]> synonymMap = new HashMap<String, String[]>();

    String s[] = new String[] { "x1", "x2", "x3" };
    String t[] = new String[] { "y1", "y2", "y3" };
    String u[] = new String[] { "z1", "z2", "z3" };

    synonymMap.put("x", s);
    synonymMap.put("y", t);
    synonymMap.put("z", u);

    return synonymMap;

}