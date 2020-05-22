public String toStringHierarchy(int tabLevel){
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < tabLevel; i++){
        builder.append("\t");
    }
    builder.append("-" + name);
    builder.append("\n");
    for(Item nextChild : children){
        builder.append(nextChild.toStringHierarchy(tabLevel + 1));
    }
    return builder.toString();
}