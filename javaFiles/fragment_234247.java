<%! 
JspWriter jout = null;
public void doSomething() 
{
   jout.print("<p>Hello World</p>");
}
%>
<%
jout = out;
doSomething();
%>