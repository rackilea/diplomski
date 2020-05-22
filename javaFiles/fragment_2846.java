public E pop() throws EmptyStackException {
    if(count == 0) {
        throw new EmptyStackException();
    } 
    return data[--count];
}