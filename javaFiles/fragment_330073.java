public class SomeServlet extends GenericServlet {
        public void destroy(){
            InitialContext ctx = null;
            try{
                ctx = new InitialContext();
                DataSource ds = (DataSource)ctx.lookup("java:/someDataSource");
                doStuff();
            }catch(Exception e){
                log.error("Bad things happened",e);
            }

            finally{
                try {
                    ctx.close();
                } catch (NamingException e) {
                    e.printStackTrace();
                }
            }
         }//destroy()
    }//class