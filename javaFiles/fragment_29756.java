@Inject
@DAOProducer
private Instance<GenericDAO<?,?>> genericDaoInst;

protected GenericDAO<?,?> getDao(DAO dao) {
    return genericDaoInst.select(new DAOTypeLiteral(dao)).get();
}