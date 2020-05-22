/**
multiplekeys taken from http://wiki.processing.org/index.php?title=Keep_track_of_multiple_key_presses
@author Yonas Sandbæk http://seltar.wliia.org
*/

// usage: 
// if(checkKey("ctrl") && checkKey("s")) println("CTRL+S");  

boolean[] keys = new boolean[526];
void draw(){}
boolean checkKey(String k)
{
  for(int i = 0; i < keys.length; i++)
    if(KeyEvent.getKeyText(i).toLowerCase().equals(k.toLowerCase())) return keys[i];  
  return false;
}

void keyPressed()
{ 
  keys[keyCode] = true;
  println(KeyEvent.getKeyText(keyCode));
}

void keyReleased()
{ 
  keys[keyCode] = false; 
}