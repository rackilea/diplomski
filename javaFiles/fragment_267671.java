try {
    // Not sure why you need to catch Exception here?
    // If it's for flow control (absent entry in a Map), it's a bad practice.
    // Just check it instead of catching NullPointerException.
    reviewContent.setOptionName((String) 
            ((Map<String, Object>) optionInfo.get().getBody().get("data"))
                    .get("dealTitle"));
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
    LOGGER.error("asyncGetDealOption", e);
    reviewContent.setOptionName(null);
} catch (CancellationException | ExecutionException e) {
    LOGGER.error("asyncGetDealOption", e);
    reviewContent.setOptionName(null);
}