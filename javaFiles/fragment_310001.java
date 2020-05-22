if(node != null){
    if(node.element.code().equals(code)){
       return node.element;
    } else {
        Node tempNode = find_X_by_code(node.left, code);
        if(tempNode == null) {
            tempNode = find_X_by_code(node.right, code);
        }
        return tempNode.element;
     }
} else {
    return null;
}