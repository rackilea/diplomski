/**
 * Create a new instance of Question given the following parameters:
 * 
 * @param  question This is the question
 * @param  answer This is the answer
 * @param  answerCorrect Whenever someone guesses correct, print this
 * @param  answerWrong Whenever someone guesses wrong, print this
 */
public Question(String question, String answer, String answerCorrect, String answerWrong) {

    this.question = question;
    this.answer = answer;
    this.answerCorrect = answerCorrect;
    this.answerWrong = answerWrong;

}