/* you start algorithm by calling recursivePrint(root) */

void recursivePrint(node){

    if (node is a leaf){

        /* Here print node's value/values */

    } else if (node has 2 children){

        recursivePrint(node.leftChild);
        /* Here print node's value */
        recursivePrint(node.rightChild);

    } else if (node has 3 children)

        recursivePrint(node.leftChild);
        /* Here print node's left value */
        recursivePrint(node.middleChild);
        /* Here print node's right value */
        recursivePrint(node.rightChild)

    }

    /* Shouldn't be other cases in 2-3 trees */
}