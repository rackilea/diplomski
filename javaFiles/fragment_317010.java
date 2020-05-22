public ArrayList<String> getLinks() {

    String link = "";

    for(int i = 0; i<url.length()-6; i++) {
        if(url.charAt(i) == 'h' && url.charAt(i+1) == 'r') {
            for(int k = i; k<url.length();k++ ){
                if(url.charAt(k) == '>'){
                    link = url.substring(i+6,k-1);
                    links.add(link);
                    // Break the loop 
                    k = url.length();
                }
            }
        }
    }
    return links;