private Observable<CheckStatus> getCheckObservable() {
return Observable.defer(() -> {
    DataDTO dto;
    try {
        dto = Utils.decryptData(
            localfile.getNonce(),
            localfile.getEncryptedData(),
            password);
    } catch (WrongPasswordException e) {
        return Observable.just(CheckStatus.WRONG_PASSWORD);
    }
    try {
        storeDataPrefs(dto);
    } catch (RuntimeException e) {
        return Observable.just(CheckStatus.OTHER_ERROR);
    }
    storeDatabase(dto);

    return initRemoteData();       // <-- CHANGES
});
}