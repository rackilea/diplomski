@PostConstruct
 public void init(){
     Map<String, Object> beans = applicationContext.getBeansWithAnnotation(Myannotation.class);

     for (Map.Entry<String,Object> entry : beans.entrySet()) {
               Client c = (Client) entry.getValue();
               Optional<Gateway> gateway = findMatchingGateway(c);
               if (gateway.isPresent()){
                     c.setGateway(g);
                     gc.getGatewayList()
                       .removeIf(o->o.getId()==g.getId())
               )
               else {
                     // handle the not found case
               }


           }
     }
 } 


private Optional<Gateway> findMatchingGateway(Client client){
    return 
      gc.getGatewayList()
        .stream()
        .filter(g.nbrInputs() == client.getNbrInputs())
        .findAny();
}