isRequest1Finished = false;
isRequest2Finished = false;

response1 = null;
response2 = null;

volleyRequest1(new Response.Listener<Something>() {
  @Override
  public void onResponse(Something response) {
    isRequest1Finished = true;
    response1 = response;
    doSomething();
  } 
})

volleyRequest2(new Response.Listener<Something>() {
  @Override
  public void onResponse(Something response) {
    isRequest2Finished = true;
    response2 = response;
    doSomething();
  } 
})

//....do on all of your requests