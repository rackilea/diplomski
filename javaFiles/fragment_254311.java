try {
     em.persist(entity);
     em.flush();
} catch(Exception ex) {
     ex.printStackTrace();
}