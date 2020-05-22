public static int updateBatch(List<MyModel> attendingUsrList) {
    SqlSession session = ConnectionBuilderAction.getSqlSession();
    PartyDao partyDao = session.getMapper(PartyDao.class);
    try {
        if (attendingUsrList.size() > 0) {
            partyDao.updateAttendingCountForParties(attendingUsrList);
        }
        session.commit();
    } catch (Throwable t) {
        session.rollback();
        logger.error("Exception occurred during updateBatch : ", t);
        throw new PersistenceException(t);
    } finally {
        session.close();
    }
}