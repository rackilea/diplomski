public static void main(String[] args) throws Exception {
    Http http = new Http();
    CompletableFuture<Response> future = 
            CompletableFuture.supplyAsync(() -> http.getPage("http://google.com"));

    //the preceding statement will call `getPage` on a different thread.
    //So you can do other things before blocking with next statement

    Response resp = future.join();
}