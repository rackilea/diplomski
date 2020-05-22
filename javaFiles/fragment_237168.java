setContentView(/*...*/);
if (savedInstanceState != null){
    qid = savedInstanceState.getInt(KEY_INDEX,0);
}
// Now load your question with the qid
currentQ = mQuestionList.get(qid);