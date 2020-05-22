@Test
    public void testMe() {
        List<Map<String, Object>> englishResult = new ArrayList<>();
        Toto toto = new Toto();
        toto.setName("Toto it's me");
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("mapKey", toto);
        englishResult.add(m);

        Gson gson = new Gson();
        String jsonEnglishResult = gson.toJson(englishResult);
        System.out.println(jsonEnglishResult);
    }