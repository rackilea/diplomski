// Inner class because it's just used to be thrown out of
// the action listener implementation to signal that the
// index exists
private class ExistsException extends RuntimeException {
}

public boolean exists() {
    logger.info(String.format("Verifying existence of index \"%s\"", indexName));
    IndicesExistsRequest request = new IndicesExistsRequest(indexName);
    try {
        adminClient.exists(request, new ActionListener<IndicesExistsResponse>() {
            public void onResponse(IndicesExistsResponse response) {
                if (response.isExists()) {
                    throw new ExistsException();
                }
            }
            public void onFailure(Throwable e) {
                ExceptionUtil.smash(e);
            }
        });
    }
    catch (ExistsException e) {
        return true;
    }
    return false;
}