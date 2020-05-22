@Autowired
 private EmailAsyncService asyncService;

 ... // ex: in controller
 asyncService.sendEmail(user, email); // the code in this method will be executed in a separate thread (you're calling it on a proxy)
 return view; // returns right away