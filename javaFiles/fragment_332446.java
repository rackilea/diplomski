<div id="#{cc.clientId}">
  <ui:param name="firstname" value="#{cc.clientId}_firstname" />
  <h:panelGroup styleClass="#{not requestScope[firstname].valid ? 'error' : ''}">
    <div class="col220">
        <h:outputLabel for="firstname" value="Vorname(n):" />
    </div>
    <div class="col220">
        <h:inputText id="firstname" styleClass="fmTxt " 
            value="#{cc.attrs.value}" binding="#{requestScope[firstname]}">
            <f:validateRequired />
        </h:inputText>

    </div>
  </h:panelGroup>
</div>