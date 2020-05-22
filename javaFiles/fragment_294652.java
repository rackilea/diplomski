public boolean insert(Entity o) {
    o.setCreated(new Date());
    this.getEntityManager().persist(o);
    this.getEntityManager().flush();
    return true;
}