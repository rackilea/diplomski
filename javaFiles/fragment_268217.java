<table>
    <ui:repeat var="elem" value="#{yourMB.yourDataList}">
        <tr>
            <td>#{elem.userid}</td>
            <td>
               <h:outputText value="#{elem.name}" 
                    rendered="#{not elem.editable}" />
               <h:inputText value="#{elem.name}" rendered="#{elem.editable}" />
            </td>
            <td>
               <h:outputText value="#{elem.telephone}" 
                    rendered="#{not elem.editable}" />
               <h:inputText value="#{elem.telephone}"
                            rendered="#{elem.editable}" />
            </td>
            <td>
              <h:commandLink value="Edit" rendered="#{not elem.editable}"
                 action="#{yourMB.editAction(elem)}" />
            </td>
        </tr>
    </ui:repeat>
</table>
<h:commandButton value="Save Changes" action="#{yourMB.saveAction}" />