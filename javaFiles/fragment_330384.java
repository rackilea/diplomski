background(255);
String[] words = {"ini","mini","miny","moe"};
for(int i = 0 ; i < words.length; i++){
   fill(map(i,0,words.length, 0,255));
   text(words[i],10,10*(i+1));
}