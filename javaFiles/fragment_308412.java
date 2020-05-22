@Service
class TennisCoach implements Coach {

    private Coach soccerCoach;

    @Autowired
    public TennisCoach(@Qualifier("soccerCoach") Coach soccerCoach) {
        this.soccerCoach = soccerCoach;
    }

    public Coach getCoach() {
        System.out.println(soccerCoach.getClass());

        return soccerCoach;
    }

}