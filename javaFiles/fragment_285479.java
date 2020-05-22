try{
    ApplicationContext context = new ClassPathXmlApplicationContext("demo/xml/application-beans.xml");
    CheckWebservice checkDecision = (CheckWebservice ) context.getBean("decisionBean");

    // Populate the Order bean
    Client decision = new Client();
    decision.setDecision("Decision test");
    boolean checkDcn = checkDecision.isWebservice(decision);
    System.out.println("Decision recived : "+checkDcn);
}catch(Exception e){
e.printStackTrace();
}