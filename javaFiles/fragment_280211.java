int index = -1;
for(int i=0; i < 3; i++){
   index = html.indexOf("<div",index + 1);
   if(index == -1)
      throw new Exception();
}