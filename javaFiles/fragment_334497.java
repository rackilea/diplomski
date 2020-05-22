private AtomicBoolean shouldExecute;

@PostConstruct
    public void init(){
        users = new ArrayList<>();
        shouldExecute = true;
    }

@Scheduled(fixedRate = 3600000)
public void load(){
    if(shouldExecute){
       // load list of users from (say) a file and populate ArrayList 'users'
    // this method takes at least 3 mins to finish
    } 
}