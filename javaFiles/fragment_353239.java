public int doStartTag() throws javax.servlet.jsp.JspException {        
//Access UserName and EmpID fields in this method. 

name = (String)pageContext.getAttribute("name",PageContext.PAGE_SCOPE);
empId = (String)pageContext.getAttribute("empId",PageContext.PAGE_SCOPE);
return Tag.SKIP_BODY;         
}