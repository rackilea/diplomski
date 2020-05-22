@Autowired
private SimpMessagingTemplate template;


public void "mymethodsender" ()
{  this.template.convertAndSend("/test/somepathwhereyouregisteredyourclienttoreceivemessages", "messageobject");
}