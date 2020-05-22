...
<!-- NOTE the 'myBacking' instead of the 'userGroupBacking' -->
<!-- Login Dialog -->
    <p:dialog id="loginDialog" header="Login" widgetVar="loginWidget" modal="true" visible="#{!myBacking.hasAccess}" closable="false">
        <h:form id="loginForm">
            <p:messages id="loginFormMessages" severity="error" autoUpdate="true" showDetail="true" />
            <h:panelGrid columns="2" cellspacing="10" width="300">  

            <p:outputLabel for="username" value="Username" />  
            <p:inputText id="username" value="#{accessBacking.username}" required="true" requiredMessage="Username is Required" />

            <p:outputLabel for="password" value="Password" />  
            <p:password id="password" value="#{accessBacking.password}" required="true" requiredMessage="Password is Required" />

            <h:panelGroup></h:panelGroup>
                <h:panelGroup>
                    <p:commandButton value="Login" styleClass="ui-priority-primary" actionListener="#{myBacking.checkViewAccess}" oncomplete="handleAuthenticationRequest(xhr, status, args)" update="loginFormMessages" />
                </h:panelGroup>
            </h:panelGrid> 
        </h:form>
    </p:dialog>
...