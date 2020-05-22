<jnlp spec="1.0+" 
      codebase=<%=request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/" %> 
      href="jnlpfile.jnlp&#063;username=<%=request.getParameter("username")%>&clienttoken=<%=request.getParameter("clienttoken")%>">

    ...
    <application-desc main-class="test.MainClass">
       <argument><%=request.getParameter("username")%></argument>
    </application-desc>
</jnlp>