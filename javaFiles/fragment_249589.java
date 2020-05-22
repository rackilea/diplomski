public void populateProfilePicture(int blobFileID, String employeePhoto) throws Exception {

    // this is about you figuring out JPA.
    EntityManager entityManager = getEntityManager()
    EntityTransaction transaction = entityManager.getTransaction();
    transaction.begin()
    try {

    Documents documents = entityManager.find(Documents.class, blobFileID);
    byte[] data readImage( employeePhoto );
    documents.setDocumentname( data );
    } catch(Exception e) {
        transaction.setRollbackOnly();
        throw e
    }
    } finally {
        transaction.commit();
    }
}