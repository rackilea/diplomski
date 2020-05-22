for( int i=0;i<=line.length;i++)
{ 
    String ln=line[i];
    if(ln.endsWith(".css")
              || ln.endsWith(".fla") 
              || ln.endsWith(".swf") 
              || ln.endsWith(".jpg"))){
        continue;
    } else {
        System.out.println("urls :"+ln);
    } 
}