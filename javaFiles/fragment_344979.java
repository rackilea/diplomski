/*
 * I suggest this solution, but not this approach, 
 * please be careful with multi-threading programming. :)
 */

// [...]
// private List<WMSMaterial> listMaterials; // or using a class member
// [...]
public void insertMaterial(final List<WMSMaterial> listMaterials) {

new Thread(){

  public void run(){
    com.ssn.acx.api.configuration.ParameterSet ps = com.ssn.acx.api.ACXObjectFactory.getConfigurationFactory().getLocalConfiguration().getParameterSet(com.ssn.acx.api.persistence.ACXPersistenceFactory.CFG_DEFAULT);
    com.ssn.acx.api.persistence.ACXPersistenceFactory factory = com.ssn.acx.api.ACXObjectFactory.getPersistenceFactory(ps);
    com.ssn.acx.api.persistence.ACXPersistenceSession session = factory.openSession();
    com.ssn.acx.api.common.transaction.ACXTransaction tx = null;

    try {
      tx = session.beginTransaction("InsertMaterial");                    

      for (WMSMaterial material : listMaterials) {
          session.getPersistenceSession().insert(material);
      }

      tx.commit();

    } finally { if (tx != null && !tx.closed()) { tx.rollback(); } session.close(); }//end of try-catch-finally block

  }//end of run method

}.start(); //end of Thread Object creation


}   //end of insertMaterial method