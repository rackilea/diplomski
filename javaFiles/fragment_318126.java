try {
325         session =     getSessionFactory().getCurrentSession();
326         }
327         catch (HibernateException ex) {
328             logger.debug("Could not retrieve pre-bound Hibernate session", ex);
329         }
330         if (session == null) {
331             session = getSessionFactory().openSession();
332             session.setFlushMode(FlushMode.MANUAL);
333             isNew = true;
334         }