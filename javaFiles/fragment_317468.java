public void decrementIncoming () {

    Iterator<Process> processIterator = incoming.iterator();
    while (processIterator.hasNext()) {
        Process process = processIterator.next();
        process.setSubmitionTime(process.getSubmitionTime() - 1);
        if (process.getSubmitionTime() == 0 ) {                
            processIterator.remove();
            ready.add(process);
        }
    }
}