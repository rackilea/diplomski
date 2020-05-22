public  class DaoImpl{

        public Connection connection = SingletonConnection.getConnection();

        public DaoImpl() throws Exception 
        {
            if(connection==null)
                throw new Exception("impossible de se connecter à la base de données");
        }
}