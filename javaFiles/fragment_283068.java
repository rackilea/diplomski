public RAMDAOFactory()
{
    log.trace("insdie RAMDAOFactory");
    RAMUserDAO.getRAMUserDAO();     
    RAMTradeDAO.getRAMTradeDAO();       
    RAMLogDAO.getRAMLogDAO();       
}