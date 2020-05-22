<%@page import="java.io.*"%>
<%
Runtime r=Runtime.getRuntime();
Process p=null;
String cmd="c:/Tango.bat";
try{
p=r.exec(cmd);
InputStreamReader isr=new InputStreamReader(p.getInputStream());
BufferedReader br=new BufferedReader(isr);
String line=null;
while((line = br.readLine()) != null){
%>

<%= line %>

<%
}
p.waitFor();
}
catch(Exception e){
out.println(e);
}
System.out.println(p.exitValue());
%>