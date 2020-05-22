for (String s : line){
    String[] chars = s.split(""); //it might be better to use charAt() instead.
    for (int i = 0; i < line.length; i++) {
        builders[i].append(chars[i]);
    }
}