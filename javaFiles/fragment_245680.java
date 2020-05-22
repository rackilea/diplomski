@import model.Question
@import model.Answer

@(myMap: Map[Question, List[Answer]])

@for((key, value) <- myMap){
  @key.questionText<br>
  @for(ans <- value){
     <p>Possible answer: @ans.answerText</p>
  }
}