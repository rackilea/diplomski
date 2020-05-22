// Why the type of tempSize is double? It should be `int`
public void resize (int tempSize) {
    //create the temp array of size tempSize  
    T[] temp = (T[]) Array.newInstance(array.getClass().getComponentType(), 
                                       tempSize);
    System.arraycopy(array, 0, temp, 0, tempSize);
    array = temp;
}