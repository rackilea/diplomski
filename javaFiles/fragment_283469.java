else {
    HeapNode leftResult = getHeapNodeRec(key, curr.getLeft());
    if (leftResult != null) { 
        return leftResult; 
    }

    HeapNode rightResult = getHeapNodeRec(key, curr.getRight());
    if (rightResult != null) { 
        return rightResult; 
     }
}