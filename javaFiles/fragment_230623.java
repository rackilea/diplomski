class Service {
  private DatabaseBarRepo barRepo;
  private DatabaseFooRepo fooRepo;

  @Transactional
  public void serviceRoutine() {
     barRepo.doStuff();
     fooRepo.doStuff();
  }
}