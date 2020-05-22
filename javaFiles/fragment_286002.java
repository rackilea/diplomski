public void next() {
    if(needInput)
        readInput();
    else
        throwException();
}

void readInput() {
     int n = 0;
     try {
          n = underlyingStream.read(buf);
     } catch (IOException ioe) {
          lastException = ioe;
          n = -1; //error happened
     }

     if (n == -1)
          underlyingStreamClosed = true;
}

void throwException() {
     if (underlyingStreamClosed)
          throw new NoSuchElementException();
     else
          throw new InputMismatchException();
}