String json="{\n" +
           "\n" +
           "    \"date\":\"14\",\n" +
           "    \"day\":\"1\",\n" +
           "    \"hours\":\"16\",\n" +
           "    \"minutes\":\"16\",\n" +
           "    \"month\":\"6\",\n" +
           "    \"seconds\":\"30\",\n" +
           "    \"time\":\"1405325790674\",\n" +
           "    \"timeInMicros\":\"1405325790674917\",\n" +
           "    \"timezoneOffset\":\"-480\",\n" +
           "    \"year\":\"114\"\n" +
           "\n" +
           "}";

   Date date=new Gson().fromJson(json,Date.class);