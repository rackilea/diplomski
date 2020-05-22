@Bean
public SimpleOrderManager orderManager(){
    SimpleOrderManager orderManager = new SimpleOrderManager();

    orderManager.setMailSender(mailSender());
    orderManager.setTemplateMessage(templateMessage());

    return orderManager;
}