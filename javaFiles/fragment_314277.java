<%@ taglib prefix="s" uri="/struts-tags" %>

<%boolean bool_val=true;%>
real value : <%=bool_val%><br/>
expression evaluated value : 
<s:set var="bool_val"><%=bool_val%></s:set>
<s:if test="#bool_val == 'true'">
    TRUE
</s:if><s:else>
    FALSE
</s:else>