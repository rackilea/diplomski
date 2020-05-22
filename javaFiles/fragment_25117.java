try {
    while (true) {
        object = objectInputStream.readObject();
        // ...
    }
}
catch (EOFException exc) {
    // end of stream
}