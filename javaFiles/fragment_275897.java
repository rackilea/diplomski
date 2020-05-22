String[] logs={"a","b","c"};
int errors=0;
for(String str:logs){
  try{
    LogParser.parse(str);
  } catch(Exception e){ // <-- try this
    error++;
    continue;
  }
}