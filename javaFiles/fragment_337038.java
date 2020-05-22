final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .excludeFieldsWithModifiers(TRANSIENT) // STATIC|TRANSIENT in the default configuration
            .create();
    final String json = gson.toJson(new DyescapeCOREConfiguration());
    System.out.println(json);