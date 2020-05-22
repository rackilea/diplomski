finalText = textField.getText().toString();

String[] textArrayWithFullStop = finalText.split("\\. ");
String colelctionOfFiveSentences = "";
int sentenceAdded = 0;

List<String>textCollection = new ArrayList<String>();
for(int i=0;i<textArrayWithFullStop.length;i++)
{
    colelctionOfFiveSentences += textArrayWithFullStop[i] + ". ";
    sentenceAdded++;
    if(sentenceAdded == 5)
    {
        textCollection.add(colelctionOfFiveSentences);
        colelctionOfFiveSentences = "";
        sentenceAdded = 0;
    }
 }