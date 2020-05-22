Type collectionType = new TypeToken<List<Show>>() {
    }.getType();
    String jsonString="[\n" +
            "\n" +
            "    {\n" +
            "        \"showId\":410,\n" +
            "        \"siteId\":85,\n" +
            "        \"name\":\"Майстер і маргарита\",\n" +
            "        \"duration\":7200,\n" +
            "        \"providerId\":1016,\n" +
            "        \"events\":[\n" +
            "            {\n" +
            "                \"siteId\":85,\n" +
            "                \"eventSiteId\":0,\n" +
            "                \"providerId\":1016,\n" +
            "                \"eventId\":1178,\n" +
            "                \"hallId\":0,\n" +
            "                \"premiere\":false,\n" +
            "                \"origin\":\"20140912190000\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "\n" +
            "]";
    List<Show> showList=new Gson().fromJson(jsonString,collectionType);
    Shows shows=new Shows();
    shows.setShows(showList);
    System.out.println(shows);