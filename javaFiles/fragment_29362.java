public void flush(Audit... audits) {
    Collection<Audit> auditCollection = Arrays.asList(audits);
    this.queue.addAll(auditCollection);

    Collection<Audit> poissonedAudits = new ArrayList<Audit>();
    Audit audit = null;
    while ((audit = this.queue.poll()) != null) {
       try {
          // save audit object on database
          queue.remove(audit);
        } catch (DataAccessException e) {
          // log it
          poissonedAudits.add(audit);
        }
    }
    this.queue.addAll(poissonedAudits);
}