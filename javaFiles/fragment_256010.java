<form action="#{checkoutBean.sagepayURL}" method="post"
    id="SagePayForm" name="SagePayForm">
    ...
    <input type="button" value="Proceed to Checkout" onclick="preprocess()" />
</form>

<h:form>
    <o:commandScript name="preprocess" action="#{checkoutBean.preprocess}"
        oncomplete="document.getElementById('SagePayForm').submit()" />
</h:form>