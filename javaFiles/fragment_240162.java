jasperReport.setProperty( "net.sf.jasperreports.query.executer.factory.plsql"
                            ,"com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");

//Maybe this too, but not positive
JRProperties.setProperty( JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX+"plsql"
                           ,"com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");