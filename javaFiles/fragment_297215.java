// OptaPlanner 6.0
URL r = SolverFactory.class.getResource("/resources/todoScoreRules.drl"); 
System.out.println("Resource found: " + (r == null));

// OptaPlanner 6.1+
URL r = SolverFactory.class.getClassLoader().getResource("resources/todoScoreRules.drl"); 
System.out.println("Resource found: " + (r == null));