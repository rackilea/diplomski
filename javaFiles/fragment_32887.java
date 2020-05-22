private static NotifyService notifyService;

@Autowired
public void setNotifyService(NotifyService notifyService){
    NotifyMain.notifyService= notifyService;
}