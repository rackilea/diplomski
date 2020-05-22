UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();

PersistenceManager pm = PMF.get().getPersistenceManager();
Employee employee = pm.getObjectById(Employee.class, user.getEmail());
Team employee.getTeam();