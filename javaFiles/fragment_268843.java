while (s.hasNextLine()){ //no need for "== true"
    String read = s.nextLine();
    if(read == null || read.isEmpty()){ //if the line is empty
        break;  //exit the loop
    }
    in.add(read);
    [...]
}