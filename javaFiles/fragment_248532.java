int read;

BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8);
while((read = reader.read(buffer, 0, 5120))>0){
    int offset = 0;
    for(int i = 0; i<read; i++){
        char c = buffer[i];
        if(c=='\n'){
           lineCount++;
           if(lineCount==maxLineCount){
              //write the range from 0 to i to your old writer.
              writer.write(buffer, offset, i-offset);
              writer.close();
              offset=i;
              lineCount=0;
              writer = Files.newBufferedWriter(Paths.get(newName), StandarCharset.UTF_8);
           }
        }
        writer.write(buffer, offset, read-offset);
    }
    writer.close();
}