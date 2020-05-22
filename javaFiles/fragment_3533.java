<ui:define name="contenido">
    <ui:repeat value="#{cronogramaBean.cronogramaBB.listaParciales}" var="parciales">
        <p:fieldset legend="Cronograma">
            <p:dataTable id="tablaPacial"
                    value="#{parciales}"
                    var="parcial"
                    emptyMessage="No existen registros"
                    rows="10"
                    rowIndexVar="rowIndex"
                    sortBy="#{parcial.ordinal}"  sortOrder="ascending"
                    style="overflow: auto">
                <f:facet name="header">
                    <p:outputLabel value="#{parcial.ciclo.nombre}"/>
                </f:facet>
                <p:column headerText="Nº"
                        style="text-align: center; width: 20px">
                    <h:outputText value="#{rowIndex+1}"/>
                </p:column>
                <p:column headerText="Nombre"
                        style="width: 100px">
                    <h:outputText value="#{parcial.nombre}"/>
                </p:column>
            </p:dataTable>
        </p:fieldset>
    </ui:repeat>
</ui:define>