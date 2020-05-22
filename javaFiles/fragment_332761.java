int i = 0;
while(s.hasNextLine()) {
    String line = s.nextLine();
    if(!line.startWith("#")) {
          array[i++] = line;
    }    
}