@Autowired
private SendEmailService sendEmailService;

try {
    sendEmailService.send("abc@gmail.com", "do not reply", "this is the template mesage");
} 
catch (Exception ex) {
   ex.printStackTrace(); //but use a logger instead
}