public CustomResponse process() {
    CustomResponse msgResponse = new CustomResponse();

    List<CompletableFuture<Void>> futures = Arrays.asList(dataHelper.fetchAndUploadCSV1(),
            dataHelper.fetchAndUploadCSV2(),
            dataHelper.fetchAndUploadCSV3(),
            dataHelper.fetchAndUploadCSV4(),
            dataHelper.fetchAndUploadCSV5(),
            dataHelper.fetchAndUploadCSV6(),
            dataHelper.fetchAndUploadCSV7());

    return CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[0]))
            .thenApply(v -> {
                msgResponse.setProcessed(true);
                msgResponse.setMessageStatus("message");
                return msgResponse;
            })
            .exceptionally(throwable -> {
                msgResponse.setMessageStatus("ERROR");
                msgResponse.setErrorMessage("error");
                return msgResponse;
            }).join();
}