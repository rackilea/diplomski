private Map<String, Quizzes> loadQuizzes(InputStream jsonInputStream) throws IOException {
    Gson gson = new GsonBuilder().create();
    Type quizzesType = new TypeToken<List<Quizzes>>() {}.getType();

    try (InputStreamReader reader = new InputStreamReader(jsonInputStream, StandardCharsets.UTF_8)) {
        List<Quizzes> quizzes = gson.fromJson(reader, quizzesType);

        return quizzes
                .stream()
                .collect(Collectors.toMap(Quizzes::getQuizId, q -> q));
    }
}