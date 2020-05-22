RestHighLevelClient restHighLevelClient = mock(RestHighLevelClient.class);
when(restHighLevelClient.indexAsync(any(), any(), any())).then(a -> {
    ActionListener<IndexResponse> listener = a.getArgument(2);
    IndexResponse response = mock(IndexResponse.class);
    when(response.getResult()).then(b -> {
        return Result.UPDATED;
    });
    listener.onResponse(response);
    return null;
});
MyHelper myHelper = new MyHelper(restHighLevelClient);
Boolean result = myHelper.doIt(null).get();
assertFalse(result);