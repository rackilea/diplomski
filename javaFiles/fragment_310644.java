<ace:dataTable id="carTable"
                  value="#{dataTableBean.carsData}"
                  var="car"
                  paginator="true"
                  paginatorPosition="bottom"
                  rows="10">
        <ace:column id="id" headerText="ID" sortBy="#{car.id}"
                    filterBy="#{car.id}" filterMatchMode="contains">
            <h:outputText id="idCell" value="#{car.id}"/>
        </ace:column>
    </ace:dataTable>