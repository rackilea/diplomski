<%@page import="java.io.*"%>
<%
Runtime r=Runtime.getRuntime();
Process p=null;
String cmd="/home/shdir/runmms.sh";
try{
p=r.exec(cmd);
InputStreamReader isr=new InputStreamReader(p.getInputStream());
BufferedReader br=new BufferedReader(isr);
String line=null;
while((line = br.readLine()) != null){
System.out.println(line);
}
p.waitFor();
}
catch(Exception e){
out.println(e);
}
System.out.println(p.exitValue());
%>