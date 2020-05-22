public void add(String word)
{
    if (counter >= words.length){
        String[] newWords=new String[counter + 1];
        for(int i=0; i<words.length; i++){
             newWords[i]=words[i];
        }
        words = newWords;
    }
    words[counter]=word;   
    counter++;
}