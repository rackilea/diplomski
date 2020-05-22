Map<Class<? extends Parent>, JpaRepository> repoMapping = new HashMap<>();

  @PostConstruct
  public void init(){
    repoMapping.put(A.class, applicationContext.getBean(ARepository));
    repoMapping.put(B.class, applicationContext.getBean(BRepository));
  }
  public JpaRepository getRepo(Class<? extends Parent> classs){
     return repoMapping.get(classs);
  }