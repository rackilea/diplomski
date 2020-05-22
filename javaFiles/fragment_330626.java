int x=0; //to keep track of qustions
private List<String> mQuestionList=new ArrayList<>(); //array of question
private List<String> mAnswerList=new ArrayList<>(); //array of question answer
 displayquestion.settext(mQuestionList.get(x);//displayquestion is textview

 //nextquestion is the button when user click it will first check answer and than move to next question if answer is correct


    nextquestion.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String answer=editText.getText().toString();
            if(answer.equal(mAnswerList.get(x)){
                x=x+1;
               displayquestion.settext(mQuestionList.get(x); //answer is correct display next quesion
            }else{
              //wrong answer
            }
        }
    });