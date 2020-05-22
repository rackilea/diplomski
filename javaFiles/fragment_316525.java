Scanner s = new Scanner(file);
s.useDelimiter(""); // reads one char a time
while(s.hasNext()){
  if(s.hasNextInt(){
    // then do something with s.nextInt()
  }else{
    // then do something with s.next()
  }
}