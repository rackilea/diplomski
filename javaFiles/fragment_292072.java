import processing.data.*;

void setup(){
  size(400,400);
  background(0);

  int textX = 10;
  int textY = 20;

  JSONObject array = loadJSONObject("array.json");
  JSONArray arrayData = array.getJSONArray("data");
  for(int i = 0 ; i < arrayData.size(); i++){
    JSONObject data = arrayData.getJSONObject(i);
    String word = data.getString("word");
    JSONArray synonyms = data.getJSONArray("synonyms");
    println(word,"=",synonyms);

    //render on screen
    text(word.toUpperCase(),textX,textY);
    for(int j = 0 ; j < synonyms.size(); j++){
      String synonym = synonyms.getString(j);
      text(synonym,textX,textY + (textY * (j+1)));
    }

    //increment x position for next word
    textX += 100;
  }

}