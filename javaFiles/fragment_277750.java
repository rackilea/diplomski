class User {
    List<Answer> getAnswers() { ... }

    List<Reply> correctReplies() {
        return getAnswers().stream()
                .flatMap(answer -> answer.getReplies().stream())
                .filter(reply -> !reply.getValue().equals("INCORRECT"))
                .collect(Collectors.toList());
    }

    boolean hasCorrectReplies() {
        return getAnswers().stream()
                .flatMap(answer -> answer.getReplies().stream())
                .anyMatch(reply -> !reply.getValue().equals("INCORRECT"));
    }
}