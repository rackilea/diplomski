A parent = em.get(A.class, parentId);
A son = new A();
A daughter = new A();
son.setParentActivity(parent);
daughter.setParentActivity(parent);
em.persist(son);
em.persist(daughter);
parent.getSubActivities().add(son);
parent.getSubActivities().add(daughter);