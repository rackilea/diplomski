for (int i = 0; i < dataFromApi.size(); i++) {

    boolean isErrorCase = false;

    try {
        returnedPoolData = dataFromApi.get(i).get();

        if (returnedPoolData == null || returnedPoolData.getJsonString().isEmpty()) {              
            isErrorCase = true;
        }

    } catch (ExecutionException e) {
        log.info("" + e);
        isErrorCase = true;
    }

    this.processAndStoreData(returnedPoolData, i, calledApis, id, isErrorCase);

}