public static BoundStatement getStatement(String cql) {
    PreparedStatement ps = null;
    Session session = null;
    try {
      session = TestUtils.getInstance().getSession();
      PreparedStatement ps = holder.get(cql);
      if(ps == null) { // If PS is already present in cache, then we don't have to synchronize and make threads wait.
        synchronized {
          ps = holder.get(cql);
          if (ps == null) {
            ps = session.prepare(cql);
            holder.put(cql, ps);
          }
        }
      }
    } finally {
        //release the resources
    }
    return ps.bind();
  }