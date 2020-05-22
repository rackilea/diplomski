final float letterSpawnTime = .2f;
float timer = 0;

String completeText = "The complete text."
String drawText = "";
int stringIndex = 0;

public void update(float delta) {
  timer += delta;
  if (timer >= letterSpawnTime) {
    drawText = drawText + completeText.charAt(stringIndex);
    stringIndex++;
    timer -= letterSpawnTime;        
  }
    font.draw(someFont, drawText, x, y, etc...);
}