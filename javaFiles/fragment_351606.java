for (;;) {
    try {
        readCase = (Person) objectInputStream.readObject();
        recordList.add(readCase);
    }
    catch (EOFException exc) {
        break;
    }
}