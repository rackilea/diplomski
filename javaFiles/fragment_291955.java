Set<Child> childLazy = parentLazyLoaded.getChild();
Set<Child> childEager = parentEagerLoaded.getChild();

//then use the following methods
System.out.println("Lazy Loaded: " + Hibernate.isInitialized(childLazy));
System.out.println("Eager Loaded: " + Hibernate.isInitialized(childEager));