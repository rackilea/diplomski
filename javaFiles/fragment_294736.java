@PostConstruct
 public void init(){
      List<Gateway> lg = gc.getGatewayList();
      Map<String, Object> beans = applicationContext.getBeansWithAnnotation(Myannotation.class);

      for (Map.Entry<String,Object> entry : beans.entrySet()) {
           for(Gateway g: lg){
               Client c = (Client)entry.getValue();
                if(c.getId().equalsIgnoreCase(g.getId())){
                        c.setGateway(g);
                }
           }
      }
 }