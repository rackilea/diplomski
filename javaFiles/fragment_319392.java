@PostConstruct
private void test() {
   Task task = new Task();
   task = taskDao.saveAndFlush(task);  // reassign
   Executor ex = new Executor();
   List<Property> props = ex.getProperties();
   ... forming and adding some properties
   taskDao.saveAndFlush(task);
}