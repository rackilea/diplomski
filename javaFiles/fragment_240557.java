package example;
public class WordLength {

private String word="";
public int length=0;

public WordLength(){}

public void setWord(String w){
    word = w;
    length = word.length();
}

public String getWord(){
    return word;
}

public int getLength(){
    return length;
}

}