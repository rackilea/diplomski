EntityManager em = getEntityManager();
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<LoginNotification> query = cb.createQuery(LoginNotification.class);
Root<LoginNotification> notfRoot = query.from(LoginNotification.class);
Root<LoginEvent> eventRoot = query.from(LoginEvent.class);
...
query.where(cb.equals(notfRoot.get(Notification_.event), eventRoot.get(Event_.id)), ...(other criteria));