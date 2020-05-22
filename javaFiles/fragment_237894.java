if (...) {
    while (crunchifyIterator.hasNext()){
        handleLine(crunchifyIterator.next());
    }
} else {
    while ((line = reader1.readLine()) != null) {
       handleLine(line);
    }
}