String regex = ".*\\b" + Pattern.quote(search) + "\\b.*"; // \b is a word boundary

int counter = 0;
for(int i = 0; i < text.length; i++) {
    if(text[i].toLowerCase().matches(regex)) {
        counter++;
    }
}