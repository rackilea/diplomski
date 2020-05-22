import processing.data.*;

ArrayList<Word> words = new ArrayList<Word>(); 

void setup(){
  size(400,400);

  int textX = 10;
  int textY = 20;

  JSONObject array = loadJSONObject("array.json");
  JSONArray arrayData = array.getJSONArray("data");
  for(int i = 0 ; i < arrayData.size(); i++){
    JSONObject data = arrayData.getJSONObject(i);
    String word = data.getString("word");
    JSONArray synonyms = data.getJSONArray("synonyms");
    println(word,"=",synonyms);

    words.add(new Word(textX,textY,"hint #"+(i+1),data));

    //increment x position for next word
    textX += 100;
  }

}

void draw(){
  background(0);
  for(Word word : words){
    word.draw();
  }
}

class Word{
  String hint = "...";
  JSONObject data;

  float x,y;
  float textWidth;
  float textHeight = 20;



  Word(float x,float y,String hint,JSONObject data){
    this.x = x;
    this.y = y;
    this.hint = hint;
    this.data = data;
    textWidth = textWidth(data.getString("word"));
  }

  void draw(){
    fill(255);
    String word = data.getString("word");
    JSONArray synonyms = data.getJSONArray("synonyms");
    text(word.toUpperCase(),x,y);
    for(int j = 0 ; j < synonyms.size(); j++){
      String synonym = synonyms.getString(j);
      text(synonym,x,y + (textHeight * (j+1)));
    }
    fill(0,192,0);
    //hint tooltip
    //if mouse within word bounding box
    if((mouseX >= x && mouseX <= x + textWidth) &&
       (mouseY >= y-textHeight && mouseY <= y)){
         //render the text at mouse coordinates
         //be aware that y is the base of the text -> be sure to check out the reference for text functions (e.g. textAscent(),textDescent(),etc.)
      text(hint,mouseX,mouseY+textHeight);  
    }


  }


}