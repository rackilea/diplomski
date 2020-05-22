Approve.jsp
============

<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<jsp:scriptlet>
<![CDATA[  
org.displaytag.decorator.CheckboxTableDecorator decorator = new org.displaytag.decorator.CheckboxTableDecorator();
decorator.setId("form_no");  
decorator.setFieldName("_chk");
request.setAttribute("checkboxDecorator", decorator);        
]]>
</jsp:scriptlet>

<script type="text/javascript">
function Fnc_FormAction(action)
{   
document.forms[0].action="<%=request.getContextPath()%>/approve.do?reqCode="+action;
document.forms[0].submit();
}
function checkbox(form,form_no)
{
if(form.checked)
{
form.value= form_no;         
}    
}
</script>
<html:form method="POST" action="/approve.do" styleClass="FORM" styleId="form" style="form">    
<display:table name="result" export="false" class="displaytag"
requestURI="/approve.do?reqCode=approve" id="ReportTable"
uid="ReportTable" cellpadding="0" style="width:1200px"
decorator="checkboxDecorator" excludedParams="updateList">
<display:column title="Check To Approve">
<input name="form_no" type="hidden" value="<%=((Approval)ReportTable).getForm_no() %>" />
<input type="checkbox" name="chk" value="<%=((Approval)ReportTable).getForm_no() %>" onclick="checkbox(this,<%=((Approval)ReportTable).getForm_no() %>)">
</display:column>
<input type="button" name="Approve" id="Approval" value="  Approve  " onclick="Fnc_FormAction('approveByRoles')"/>
</display:table>


ApproveActionForm
==================
private int chk[];
/**
* @return the chk
*/
public int[] getChk() {
return chk;
}
/**
* @param chk the chk to set
*/
public void setChk(int[] chk) {
this.chk = chk;
}



ApproveAction.java
==================

public ActionForward approveByRoles(ActionMapping mapping, ActionForm form,
HttpServletRequest  request,HttpServletResponse response) throws STException 
{
ApproveActionForm aprForm=(ApproveActionForm)form;
if(aprForm.getChk()!=null)
{  
int chks[] = aprForm.getChk();
int updateFormNo = 0;
for(int i=0;i<chks.length;i++)
{   
updateFormNo = chks[i];
System.out.println("Updated Form Number is = "+ updateFormNo);
}   
}
}