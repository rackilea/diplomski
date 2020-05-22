request.execute();
...

 processStreamingEntity(response.getEntity());
 response.close();

//implement your own wrapper as mentioned in apache docs

    private void processStreamingEntity(HttpEntity entity) throws IOException {
        InputStreamHttpEntityHC4 bufHttpEntity = new InputStreamHttpEntityHC4(entity);
        while not bufHttpEntity.LAST_CHUNK {
            handleResponse(bufHttpEntity.readLine())
}