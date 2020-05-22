public class Controller1{

    private Service service;

    public ReponseEntity<?> doWhatController1HasToDo(@RequestBody Object request){
       return new ResponseEntity<>(service.processController1(request), OK);
    }
}