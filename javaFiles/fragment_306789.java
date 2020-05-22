for (String s : tempFile){
    String [] splitted = s.split(" ");
    if (splitted[0].equals(naam)){
        tempFile.remove(s);
        found = true;   
    }
}