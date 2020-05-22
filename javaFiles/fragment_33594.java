[...]
<h:form id="editform" rendered="#{gvpController.logInBean.gvpView}">
    <fieldset>
        <h3>Wijzig een titel</h3>
        <label>
            <span>Titel:</span>
            <h:selectOneMenu value="#{faseController.selectedFase.parent_id}" valueChangeListener="#{faseController.prepareEditView}" onchange="submit()" immediate="true">
                <f:selectItems value="#{faseController.fasesAsSelectItems}" />
            </h:selectOneMenu><br />
        </label>
        <h:inputTextarea id="textboxParent" value="#{faseController.selectedFase.titel}" />
        <br />
        <ui:repeat value="#{faseController.selectedFase.subItems}" var="subfase">
            <h:inputTextarea value="#{subfase.titel}" />
        </ui:repeat>
    </fieldset>
</h:form>
[...]