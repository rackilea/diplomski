// Your mentioned code
Bundle b = getIntent().getExtras();
CharSequence[] questionsCorrect = b.getCharSequenceArray("questionsCorrect");
CharSequence[] answersCorrect = b.getCharSequenceArray("answersCorrect");

// Create a list of questions and answers. Make sure both arrays have same length
QAnsModel model;
ArrayList<QAnsModel> dataList = new ArrayList<>();
for(int i = 0; i < questionsCorrect.length; i++)
{
    model = new QAnsModel(questionsCorrect[i].toString(), answersCorrect[i].toString());
    dataList.add(model);
}