/** Returns the index of the last occurance of target in items */
public static int findLastOccurance(Object[] items, Object target){
    return findLastOccurance(items, target, items.length - 1);
}

/** Helper method for findLastOccurance(items, target). Recursively finds
  * the index of the last occurance of target in items[0...cur]
  */
private static int findLastOccurance(Object[] items, Object target, int cur){
    if(curr == -1) //We went past the start - missed it.
        return -1;
    else if (target.equals(items[cur])) //Found it
        return cur;
    else
        return lineSearchLast(items, target, curr-1); //Work backwards
}