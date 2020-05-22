<script>

var productionSourceListString = document.getElementById("hiddenField").value;
var productionSourceListArray = productionSourceListString.split(',\"*\",');
var b = JSON.parse(productionSourceListArray);
var data={"users" :b};


var finalData =$.map(data.users, function(item) {

              return {

                   label:item.label,
                   value:item.value,
                   id: item.id
            }

           });


</script>

<h1>
    <h:outputText value="#{msg['recurring_split']}" styleClass="home_message" />
</h1>

<fieldset>

    <legend>Recurring Split</legend>

    <h:panelGrid columns="4" cellpadding="2" style="width:500px;">

        <h:outputLabel for="production_source" value="#{msg['production_source']}">
            <h:outputText value="#{msg['edit_alert']}" escape="false" />
        </h:outputLabel>    
        <h:inputText   id="production_source" style="width:80px; overflow:hidden" value="#{recurringSplitBean.item.productionSource.productionSourceCode}">

        </h:inputText>

        <h:inputText  id="production_source_description" style="width:180px ;background-color: #E5E5E5;" value="#{recurringSplitBean.item.productionSource.description}">

        </h:inputText>