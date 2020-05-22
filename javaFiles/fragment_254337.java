@PostConstruct
public void init() {
   try {
      entityManager = Emf.getInstance().getFactory().createEntityManager();
  } catch (Exception e) {
            // TODO Auto-generated catch block
      e.printStackTrace();
  }
}