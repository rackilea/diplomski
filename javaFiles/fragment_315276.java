for (int i = 0; i < node.getChildren().length; i++){
    result = find(label, node.getChildren()[i];
    if(result != null) {
        return result;
    }
}