while(s != null) {
    String [] words = s.split(" ");
    for(String str : words) {
        if((str.startsWith("a") || str.startsWith("A")) 
              && (str.endsWith("a") || str.endsWith("A"))) {
            ++n;
        }
    }
    s = r.readLine();
}