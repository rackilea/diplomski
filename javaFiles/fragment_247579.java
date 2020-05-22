String myBuff = "";
char charBuff;
while(myBuff.length()<30)myBuff+=(char)br.read();

charBuff=(char)br.read();
try{
  while(true){
    myBuff=myBuff.substring(1)+charBuff;
    if(myBuff.startsWith("srsName"))break;
    charBuff=(char)br.read();
  }
}
catch(Exception e){}
value = myBuff.split("\"")[1];