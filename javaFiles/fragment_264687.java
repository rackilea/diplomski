EntityManagerFactory managerFactory = null;
Map<String, String> persistenceMap = new HashMap<String, String>();

persistenceMap.put("javax.persistence.jdbc.url", "<url>");
persistenceMap.put("javax.persistence.jdbc.user", "<username>");
persistenceMap.put("javax.persistence.jdbc.password", "<password>");
persistenceMap.put("javax.persistence.jdbc.driver", "<driver>");

managerFactory = Persistence.createEntityManagerFactory("<current persistence unit>", persistenceMap);
manager = managerFactory.createEntityManager();