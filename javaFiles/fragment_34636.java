//I am app1
public void  notifyApp2(){
    final String uri = "http://localhost:8080/from";
    Greeting greeting = new Greeting(3,"Send to the other App");
    System.out.println("======================>>"+greeting.getContent());
    RestTemplate restTemplate = new RestTemplate() ;
    Greeting result= restTemplate.postForObject( uri,greeting, Greeting.class);
}


  @RequestMapping(value = "/from", method = RequestMethod.POST)
public ResponseEntity<String> createEmployee()
{
    //I am app2 and someone is calling my rest. I am being notified.
    //maybe they notify me to set my operations setOperation=true;
return new ResponseEntity(HttpStatus.ACCEPTED);