try(BufferedReader reader = new BufferedReader(new InputStreamReader(JsonListToJava.class.getResourceAsStream("example.jsonlist"), "UTF-8"))){
    Gson gson = new GsonBuilder().create();
    Stream<String> lines = reader.lines();

    lines.forEach((line) -> {
        Model p = gson.fromJson(line, Model.class);
        System.out.println(p);
    });
}