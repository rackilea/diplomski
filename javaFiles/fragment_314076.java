.panel_users {
    width:600px;
    height:400px;
    background-color:lightskyblue;
    margin:10px;
    overflow: auto;
    float:left;
}

 <h:form>
    <div class="panel_users">
        <ui:repeat var="user" value="#{indexBean.users}" >
            <ice:panelGrid columns="1" style="float: left;">
                <ice:graphicImage value="#{user.picture}"/>
                <ice:outputText value="#{user.name}"/>
            </ice:panelGrid>
        </ui:repeat>
    </div>
</h:form>