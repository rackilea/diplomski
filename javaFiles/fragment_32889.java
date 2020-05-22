private static NotifyService notifyService;

@Autowired
public NotifyMain(NotifyService notifyService){
    NotifyMain.notifyService= notifyService;
}