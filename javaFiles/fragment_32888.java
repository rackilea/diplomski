private static NotifyService notifyService;

@Autowired
private NotifyService autowiredNotifyService; //same as above but non-static this time. And you autowire this one.

@PostConstruct
private void init() {
   NotifyMain.notifyService = this.autowiredNotifyService;
}