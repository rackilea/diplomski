@Controller
public class DemoController {

    @Autowired
    private BaseDetailsRepo baseDetailsRepo;


    @GetMapping(value="/test")
    public ResponseEntity test(){

        FirstDetails fd = new FirstDetails();
        fd.setIdentifier("fd1-demo");

        FirstDetails fd1 = new FirstDetails();
        fd1.setIdentifier("fd2-demo");


        SecondDetails sd = new SecondDetails();
        sd.setIdentifier("sd1-demo");
        baseDetailsRepo.save(fd);
        baseDetailsRepo.save(fd1);
        baseDetailsRepo.save(sd);

        return new ResponseEntity("Success",HttpStatus.OK);
    }


    @GetMapping(value="/test/second/{id}")
    public ResponseEntity getSecondDetails(@PathVariable String id){
        return new ResponseEntity(baseDetailsRepo.getSecondDetailsByIdentifier(id),HttpStatus.OK);
    }


    @GetMapping(value="/test/first/{id}")
    public ResponseEntity getFirstDetails(@PathVariable String id){
        return new ResponseEntity(baseDetailsRepo.getFirstDetailsByIdentifier(id),HttpStatus.OK);
    }
}