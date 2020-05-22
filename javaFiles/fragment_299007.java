public class Facade{

    private Service1 service1;
    private Service2 service2;

    public ReponseEntity<?> doWhatController1HasToDo(@RequestBody Object request){
       Object resultService1 = service1.process(request);
       Object resultService2 = service2.process(resultService1);
       return new ResponseEntity<>(resultService2, OK);
    }

    public ReponseEntity<?> doWhatController2HasToDo(@RequestBody Object request){
       Object resultService2 = service2.process(request);
       return new ResponseEntity<>(resultService2, OK);
    }
}