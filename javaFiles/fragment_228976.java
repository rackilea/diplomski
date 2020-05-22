public void run() throws IOException {
    boolean reading = true;
    StringBuilder buffer = new StringBuilder();
    while(reading) {   
        int character = fr.read();
        if(character == -1) {   
            reading = false;
            character='\n';
        }   
        buffer.append((char)character);
        if (character == ' ' || character == '\t' || character == '\n') {
            synchronized(fw) {
                fw.write(buffer.toString()); 
            }
            buffer = new StringBuilder();
        }           
    }
}