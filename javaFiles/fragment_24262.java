String data = "{\n" +
        "    \"class2List\":[\n" +
        "        {\n" +
        "            \"point\":{\"x\":131,\"y\":304},\n" +
        "            \"pointList\":\n" +
        "                [\n" +
        "                    {\"x\":134,\"y\":319},\n" +
        "                    {\"x\":135,\"y\":333},\n" +
        "                    {\"x\":133,\"y\":348},\n" +
        "                    {\"x\":129,\"y\":349}\n" +
        "                ]\n" +
        "        },\n" +
        "\n" +
        "        {\n" +
        "            \"point\":{\"x\":311,\"y\":277},\n" +
        "            \"pointList\":\n" +
        "                [\n" +
        "                    {\"x\":312,\"y\":279},\n" +
        "                    {\"x\":315,\"y\":286},\n" +
        "                    {\"x\":318,\"y\":302},\n" +
        "                    {\"x\":321,\"y\":328},\n" +
        "                    {\"x\":321,\"y\":353}\n" +
        "                ]\n" +
        "        }\n" +
        "    ]\n" +
        "}";

PointData parsedData = new Gson().fromJson(data, PointData.class);
Log.e("JSON", parsedData.getClass2List().get(0).getPoint().getX().toString());