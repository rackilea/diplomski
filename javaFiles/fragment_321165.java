<%
    for (int counter=0;counter<myList.size();counter++) {
       // pushing it into the pageContext
       pageContext.setAttribute("counter",counter);
%>
        <s:select cssClass="login-textbox" 
                  cssStyle="width:130px" 
                      list="#masterColDO.validation" 
                      name="chngdColumnValues"      
                        id="%{'columnId' + #attr['counter']}" />
<%    
    }
%>