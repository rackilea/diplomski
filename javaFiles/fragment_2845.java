public E pop() throws EmptyStackException {
    if(count <= 0) {
        throw new EmptyStackException();
    }
    E poppedObject = data[0];
    for(int i = 0; i < count; i++) { //Moving all the elements one closer to top
        data[i] = data[i+1];
    }
    count--;
    return poppedObject;
}