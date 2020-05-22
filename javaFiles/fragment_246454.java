<rich:extendedDataTable value="#{myBean.mapKeys}" var="item"
    id="datatable">
    <rich:column width="190px" sortable="false" label="Map entries"
        id="labelColumn">
        <f:facet name="header">Map entries</f:facet>
        <h:outputText value="#{myBean.myMap[item]}" />
    </rich:column>
  </rich:extendedDataTable>