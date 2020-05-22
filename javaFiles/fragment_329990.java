public boolean check(String enterNameOfLink, String matchText) { 
    boolean match = false;

    for(int i = 0; i < link.lenght; i++){
        if(element[i].getText().trim().equalsIgnoreCase(textToCheck)){
            match = true;
        }
    }
    return match;
}