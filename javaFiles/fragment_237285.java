void keyPressed(){
  for(int i = 0; i < searchbars.length; i++){
    if(keyCode == 8){
      searchbars[i].delete();
    }
    else{
      searchbars[i].write(key);
    }
  }
}