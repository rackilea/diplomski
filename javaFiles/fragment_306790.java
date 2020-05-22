for (Iterator<String> it = tempFile.iterator(); it.hasNext();) {
    String s = it.next();
    String [] splitted = s.split(" ");
    if (splitted[0].equals(naam)){
        it.remove();
        found = true;   
    }
}