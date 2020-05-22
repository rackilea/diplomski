<form action="#{checkoutBean.sagepayURL}" method="post"
    id="SagePayForm" name="SagePayForm">
    ...
    <input type="button" value="Proceed to Checkout" 
        onclick="document.getElementById('hiddenForm:link').click()" />
</form>

<h:form id="hiddenForm" style="display:none">
    <h:commandLink id="link" action="#{checkoutBean.preprocess}">
        <f:ajax render="@form" />
    </h:commandLink>
    <h:outputScript rendered="#{checkoutBean.preprocessed}">
        document.getElementById("SagePayForm").submit();
    </h:outputScript>
</h:form>