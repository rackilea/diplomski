public String getPath(char c , BinaryNode<Character> node){
     if(node.getData() == c)//matching node found
          return "";

     if(node.right() != null){//check if right child is parent of match
          String tmp = getPath(c , node);
          if(tmp != null)//match found -> complete path from this node
               return "1" + tmp;
     }
     if(node.left() != null){//check if left child is parent of match
          String tmp = getPath(c , node);
          if(tmp != null)
               return "0" + tmp;
     }

     //c is no content of the tree with node as root -> return null
     return null;
}