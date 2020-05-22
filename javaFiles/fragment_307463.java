static String prefix(int level){
    StringBuilder s = new StringBuilder();
    for(int i = 0; i < level; i++){
        s.append("----");
    }

    return s.toString();
}