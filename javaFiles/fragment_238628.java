@Autowire
    private ApplicationContext ctx;
....
      for(Person p : personList){
         ChildUI someChild=ctx.getBean(ChildUI.class,p.getLastName(),m.getFirstName());
       }