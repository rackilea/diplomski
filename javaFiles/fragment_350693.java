String content = "";
while(true){
   String line = br.readLine();
    if(line == null) break;
    content += line;
}
return content;