public BatchElementStatus call() {
    return callMethod(1);
}

private callMethod(int methodCounter) {
    if (cancelled) {
       doRollback();
       return new BatchElementStatus("FAIL");
    }
    switch (methodCounter) {
       case 1 : doSomethingOne(); break;
       case 2 : doSomethingTwo(); break;
       ...
       case 5 : doSomethingFive();
                doSomethingSix();
                return new BatchElementStatus("SUCCESS");
    }
    return callMethod(methodCounter + 1);
}