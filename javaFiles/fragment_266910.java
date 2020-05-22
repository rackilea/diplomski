GsonBuilder builder = new GsonBuilder();
builder.registerTypeAdapter(Languages.class, new LanguagesTypeAdapter());

Gson gson = builder.create();

Languages languages = gson.fromJson("{"+
          "\"Shell\": 13401,"+
          "\"JavaScript\": 2693931,"+
          "\"Ruby\": 2264,"+
          "\"C\": 111534,"+
          "\"C++\": 940606,"+
          "\"Python\": 39021,"+
          "\"R\": 2216,"+
          "\"D\": 35036,"+
          "\"Objective-C\": 4913"+
        "}", Languages.class);

String json = gson.toJson(languages);