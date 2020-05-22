public Class methodName(){
    x = 3;
    Class y = null; // Defaults to null if not reassigned later
    if(array[x] != null){
        y = array[x]; // Reassign the pre-declared y here if necessary
    }
    return y;
}