<% 
    RegisterAction aro = new RegisterAction();
    int count = aro.getLi().size();
    pageContext.setAttribute("count", count); // pushing the variable into the pageContext
%>

<s:iterator value="li" begin="0" end="%{#attr['count']}">
    <fieldset>
        name     : <s:property value="name"     /><br/>
        password : <s:property value="password" /><br/>
        email    : <s:property value="email"    /><br/>
        gender   : <s:property value="gender"   /><br/>
        country  : <s:property value="country"  /><br/>
    </fieldset>
</s:iterator>