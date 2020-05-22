<%@ page language="java"
    import="java.io.*,java.sql.*,javax.naming.*,java.util.*" errorPage=""
    buffer="none"%>
<%@page import="com.mobios.util.LogUtil"%>

<%
out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+getServletConfig().getServletContext().getRealPath(""));

%>

<%!
public void jspInit(){
    System.out.println("+++++++++++++++++++Init+++++++++++++++++++++++++");
    String rPath = getServletConfig().getServletContext().getRealPath("");
    System.out.println("rPath "+rPath);
    LogUtil.init(rPath + "/conf/log4j.xml");
    LogUtil.getEventLog().debug("Service initialized,,,,,,,,,,,,,"); 

}
%>