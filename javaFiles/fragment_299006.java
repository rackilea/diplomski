public class Controller2{

    private Service service;

    public ReponseEntity<?> doWhatController1HasToDo(@RequestBody Object request){
       return new ResponseEntity<>(service.processController2(resultProcess1), OK);
    }
}