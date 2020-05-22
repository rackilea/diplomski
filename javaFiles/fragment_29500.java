int result = 0;
for(String s : h1.keySet()){
    if(h2.containsKey(s)){
        result = result + h2.get(s) * h1.get(s);
    }
}