@Action(Action.ACTION_TYPE.DELETE)
 public String deleteVerificationDocumentCodeTable(
                VerificationDocumentCodeTable verificationDocumentCodeTable)
                throws Exception {
    EntityManager em = getEntityManager();
                try {
                    utx.begin();
                    em.joinTransaction();
                    verificationDocumentCodeTable = em
                            .merge(verificationDocumentCodeTable);
                    em.remove(verificationDocumentCodeTable);
                    utx.commit();
                } catch (Exception ex) {
                    try {
                        utx.rollback();
                    } catch (Exception e) {
                        ex.printStackTrace();
                        throw e;
                    }
                    throw ex;
                } finally {
                    em.close();
                }
                return "";
}