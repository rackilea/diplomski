public class myQuestion {

String question;
String choiceA; 
String choiceB;
String choiceC;
String choiceD;
String correctAns;
String incorrectAns1;
String incorrectAns2;
String incorrectAns3;

public myQuestion(String question, String choiceA, String choiceB, String choiceC, String choiceD, String correctAns, String incorrectAns1, String incorrectAns2, String incorrectAns3) {
    this.question = question;
    this.choiceA = question; 
    this.choiceB  = choiceB;
    this.choiceC = choiceC;
    this.choiceD = choiceD;
    this.correctAns = correctAns;
    this.incorrectAns1 = incorrectAns1;
    this.incorrectAns2 = incorrectAns2;
    this.incorrectAns3 =incorrectAns3;
}

@Override
public String toString() {
    return this.question + 
    this.choiceA +
    this.choiceB +
    this.choiceC +
    this.choiceD +
    this.correctAns +
    this.incorrectAns1 +
    this.incorrectAns2 +
    this.incorrectAns3 ;
}

}