public java.util.List<String> getAdmin() {
        log.info("getAdmin()");

        // AppEngine does not support strong consistency... will frequently return stale results. Setting read policy won't work.
        // Construct a read policy for strong consistency
        ReadPolicy policy = new ReadPolicy(ReadPolicy.Consistency.STRONG);
        // Set the read policy
        DatastoreServiceConfig consistentConfig = DatastoreServiceConfig.Builder.withReadPolicy(policy);
        // Get Datastore service with the given configuration
        DatastoreService datastoreService =  DatastoreServiceFactory.getDatastoreService(consistentConfig);

        com.google.appengine.api.datastore.Query query  = new com.google.appengine.api.datastore.Query("AdminUser");
//      DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        java.util.List<Entity> events = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
        ArrayList<String> al = new ArrayList<String>();
        for(Entity entity: events) {
            String s = entity.getProperty("email").toString();
            al.add(s);
        }
        if(true) return al; 


        @SuppressWarnings("unused")
        EntityManager em = EMF.get().createEntityManager();
        try {
            TypedQuery<String> tq = em.createQuery("select au.email from AdminUser as au", String.class);
            return tq.getResultList();
        } catch (ClassNotResolvedException | javax.persistence.PersistenceException cnre) {
            // catch the exception because AppEngine DataStore has no way to create a new empty Entity table.
            log.warning("AdminUser entity does not exist or is empty.");
            return new java.util.ArrayList<String>();
        } finally {
            em.close(); 
        }

//      log.info("getAdmin(): al.size(): " + al.size());
    }


    public void setAdmin(java.util.List<String> admin) {
        log.info("setAdmin(), admin.size():"+admin.size());

        // delete all AdminUsers
        com.google.appengine.api.datastore.Query query  = new com.google.appengine.api.datastore.Query("AdminUser");
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        java.util.List<Entity> events = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
        for(Entity entity: events) {
            datastoreService.delete(entity.getKey());
        }


//      EntityManager em = EMF.get().createEntityManager();
//      Query q = em.createQuery("delete from AdminUser");
//      q.executeUpdate();


//      DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        for (String s: admin) {
            log.info("creating AdminUser Entity...");
            Entity e = new Entity("AdminUser");
            e.setProperty("email", s);
            datastoreService.put(e);    
        }
        // Must wait for Datastore to actually write records. Ignores consistency even with strong consistency set.
        // this doesn't even work sometimes...
        //try { Thread.sleep(5000); } catch (InterruptedException e) {}

//      EntityManager em = EMF.get().createEntityManager();
//      for (String s: admin) {
//          Entity e = new Entity("AdminUser");
//          e.setProperty("email", s);
//          em.persist(e);
//      }
//      em.close();

    } // setAdmin()