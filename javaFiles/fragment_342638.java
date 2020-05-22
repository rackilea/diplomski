private void printRequestBody(Request request) {
    RequestBody requestBody;
    if(request.body() == null){
        System.out.println(request.tag().toString());
        return;
    }else{
        requestBody = request.body();
    }

    Buffer buffer = new Buffer();
    try {
        requestBody.writeTo(buffer);
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(request.toString() + " --> "+buffer.readUtf8());

}