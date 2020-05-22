try {
    array[index] = someValue;
}
catch(ArrayIndexOutOfBoundsException exception) {
    handleTheExceptionSomehow(exception);
}