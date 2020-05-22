methodA() {
    methodB()
}

@Transactional(noRollbackFor = Exception.class)
methodB() {
    ...
    try {
        methodC()
    } catch (...) {...}
    log("OK");
}

@Transactional
methodC() {
    throw new ...();
}