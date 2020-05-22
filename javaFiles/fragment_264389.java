<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="application/pdf" %>
<%@ page trimDirectiveWhitespaces="true"%>



<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.export.*" %>
<%@ page import="java.util.*" %>


<%
Class.forName("oracle.jdbc.OracleDriver");
Connection cn =    DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:personnel","charif","charif123");

response.setHeader("Content-Disposition",  "inline; filename=report.pdf ");
JasperPrint print = JasperFillManager.fillReport("D:\\ISTA\\Projet_Stage\\GestionPersonnel\\web\\reports\\rapport_absences.jasper",
new HashMap(),
cn);


JasperExportManager.exportReportToPdfStream(print,    
response.getOutputStream());

%>