String outLine;

while ((outLine = stdOutReader.readLine ()) != null) {
    if(outLine.trim().length() > 0){
        System.out.println ("OUT STREAM: " + outLine);
    }    
}