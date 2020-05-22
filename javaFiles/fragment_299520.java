public LinkedHashSet<WsQuestion> get(String quizId, String companyId) {
  LinkedHashSet<QuizQuestionWithQuestion> toReturn = quizQuestionRepository.findAllQuizQuestionWithQuestionByQuizId(quizId);
  return (toReturn.stream()
      .map(this::createWsQuestion)
      .sorted(comparingInt(WsQuestion::getSortOrder))
      .collect(Collectors.toCollection(LinkedHashSet::new)));
}