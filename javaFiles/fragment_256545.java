public class Log4jInit implements Servlet {

@Override
public void destroy() {}

@Override
public ServletConfig getServletConfig() {return null;}

@Override
public String getServletInfo() {return null;}

@Override
public void init(ServletConfig arg0) throws ServletException {

    try{        
        DOMConfigurator.configure(getClass().getClassLoader().getResource("log4j.xml"));            
    }catch(Exception e){
        System.out.println("Log4jInit Exception : " + e);
    }

}

@Override
public void service(ServletRequest arg0, ServletResponse arg1)  throws ServletException, IOException {}

}