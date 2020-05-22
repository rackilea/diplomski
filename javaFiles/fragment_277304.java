Map<String, List<Integer>> map = new LinkedHashMap<>();

    // Assuming that you are working with query output resultset
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            List<Integer> li = new ArrayList<>();
            li.add(rs.getInt("PLAY"));
            li.add(rs.getInt("LISTEN"));
            li.add(rs.getInt("DISPLAY"));
            li.add(rs.getInt("COMMENT"));

            map.put(rs.getString("ID"), li);
        }

    } catch (SQLException e ) {
        /* SQLException handler */
    } finally {
        if (stmt != null) { stmt.close(); }
    }

    map = sortByValues(map);

    for (Map.Entry<String, List<Integer>> entry: map.entrySet()) {
        System.out.println(entry.getKey() + "," + entry.getValue());
    }

}

public static Map<String, List<Integer>> sortByValues(Map<String, List<Integer>> map) {

    List<Map.Entry<String, List<Integer>>> list = 
        new LinkedList<>(map.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<String, List<Integer>>>()        {        

        public int compare(Map.Entry<String, List<Integer>> m1, Map.Entry<String, List<Integer>> m2) {

            int sum1 = 0;
            for(Integer d : m1.getValue())
                sum1 += d;

            int sum2 = 0;
            for(Integer d : m2.getValue())
                sum2 += d;

            return (new Integer(sum2)).compareTo(new Integer(sum1));
        } 
    }) ;

    Map<String, List<Integer>> result = new LinkedHashMap<>();
    for (Map.Entry<String, List<Integer>> entry: list) {
        result.put(entry.getKey(), entry.getValue());
    }

    return result;
}