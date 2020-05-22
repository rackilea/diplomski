public class DaoRegistry {
        private Map<Class, JdbcDAO> daoMap;

        public synchronized void register (Class type, JdbcDao dao) {
                if (!daoMap.containsKey(type))
                     daoMap.put (type, dao);
                else
                     logger.error ("Something is really wrong because you are creating another dao for this class.", e);

            }

        public JdbcDAO get(Class type) {return daoMap.get(type);
}