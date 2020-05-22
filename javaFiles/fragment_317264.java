... 
if (focusNode != null){

        System.out.println(focusNode);
       list.add(focusNode);

        preOrderTraverseTree(focusNode.leftChild);

        preOrderTraverseTree(focusNode.rightChild);
    }//end if
...