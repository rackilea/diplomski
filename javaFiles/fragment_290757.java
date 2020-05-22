public Future<RedResponse> getUserAsync(RedKey rdKeys)  {
    if (RedUtils.isEmpty(rdKeys)) { 
        throw new IllegalArgumentException("rdKeys can not be empty");
    }
    ...
}