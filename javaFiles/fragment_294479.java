public class HibernateCommandExecuter {

    private static final Logger logger = Logger.getLogger(HibernateCommandExecuter.class);

    public static Object executeCommand(HibernateCommand<?> command, boolean commit, Object... args) throws RemoteException{
        try {
            HibernateUtil.currentSession().beginTransaction();

            return command.execute(args);

        } catch (HibernateException e) {
            logger.error("Hibernate problem : ", e);
            throw new RemoteException(e.getMessage());
        }catch(Exception e){
            throw new RemoteException(e.getMessage(), e);
        }
        finally {
            try{
                if(commit){
                    HibernateUtil.currentSession().getTransaction().commit();
                }else{
                    HibernateUtil.currentSession().getTransaction().rollback();
                }
                HibernateUtil.currentSession().close();
            }catch(HibernateException e){
                logger.error("Error while trying to clean up Hibernate context :", e);
            }
        }
    }   
}