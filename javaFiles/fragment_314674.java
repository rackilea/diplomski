public class ExtendedMySQL5Dialect extends MySQL5Dialect 
{
        public ExtendedMySQL5Dialect() 
        {
           super();
           registerFunction( "date_sub_interval", new SQLFunctionTemplate( Hibernate.DATE, "date_sub(?1, INTERVAL ?2 ?3)" ) );
           registerFunction( "date_add_interval", new SQLFunctionTemplate( Hibernate.DATE, "date_add(?1, INTERVAL ?2 ?3)" ) );           
        }
}