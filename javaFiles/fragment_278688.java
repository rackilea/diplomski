private boolean inUse(JDBCTemplates jdbc, BigInteger firmwareId) {
          String query = "select * from references ref " +
          "where ref.attr_id = 9 " +
          "and ref.reference ='" + firmwareId+"'";//Here might be the error
    try { 
          s = (String) jdbc.selectForObject(query....);
        } catch (Exception e) {
          log.info(e.toString());
        }
    return ...;