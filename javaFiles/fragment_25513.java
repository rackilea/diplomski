static void call(final Connection con) throws SQLException {
        Map<String, String> emailMap = new HashMap<>();
        emailMap.put("id1", "someVal");
        emailMap.put("id2", "someVal");
        emailMap.put("id3", "someVal");
        emailMap.put("id4", "someVal");

        String collect = emailMap.keySet().stream().collect(Collectors.joining(","));


        String query = " SELECT EMAIL FROM DATA_VIEW WHERE URL IN (" + collect + ")";


        try (Statement s = con.createStatement()) {

            ResultSet executeQuery = s.executeQuery(query);
            // do your result processing
        }

    }