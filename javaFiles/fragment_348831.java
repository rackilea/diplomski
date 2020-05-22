<ui:repeat value="#{facesContext.messageList}" var="facesMessage">
    Severity: #{facesMessage.severity}<br />
    Summary: #{facesMessage.summary}<br />
    Detail: #{facesMessage.detail}<br />
    <br />
</ui:repeat>