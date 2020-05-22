Event event = new Event();
event.setId(1L);

entityManager.persist(event);
entityManager.flush();

entityManager.refresh(event);

assertNotNull(event.getCreatedOn());