class Topic{
    private final String topic;
    private finaltopicName Collection<Question> questions;
    Topic(String topic, Collection<Question> ... questions){
        this.topic=topic;
        this.questions=Arrays.asList(questions);
    }
}

class Question{
    private final String question;
    private final Collection<String> answers;
    Question(String question, Collection<String>... answers){
        this.question=question;
        this.answers=Arrays.asList(answers);
}