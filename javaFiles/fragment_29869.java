//The index of the sound and input from user
int soundToPlay;
String input;

Private int findStringIndex(String input){
  for(int i = 0; i < yourStringArray.length; i++){
    if(yourStringArray[i].equals(input){
      return i;
    }
  }
//not sure if java will allow you to send null like this. If not, you will have to find another way to deal with a string that isnt in your array
return null;
}

private void findMatch(int soundToPlay, String input){
  int index = findStringIndex(input);
  if(index == null){
    //String not in array, notify user
  }
  if(index == soundToPlay){
    //match found, notify user, play next sound
  }
}