PImage fromBinaryStrings(String[] sprite){

  int h = sprite.length;
  int w = sprite[0].length();

  PImage result = new PImage(w,h,RGB);

  for(int y = 0 ; y < h; y++){
    String row = sprite[y];
    for(int x = 0; x < w; x++){
      if(row.charAt(x) == '1'){
        result.set(x,y,color(255));
      }else{
        result.set(x,y,color(0));
      }
    }
  }

  return result;
}