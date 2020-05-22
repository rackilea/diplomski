List<String> selected = new ArrayList<String>();

for(String w:wordList){
    if(w.startsWith(prefix.toLower())) // or .contains(), depending on 
        selected.add(w);     // what you want exactly 
}

return selected;