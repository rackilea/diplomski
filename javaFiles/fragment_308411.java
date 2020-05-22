@RestController
class MyController {

    @Autowired
    @Qualifier("soccerCoach")
    private Coach coach;

    @GetMapping("/")
    public String sayHello() {
        // this should invoke the workout() from SoccerCoach implementation
        System.out.println(coach.workout());

        return "Time on server is: " + new java.util.Date();
    }

}