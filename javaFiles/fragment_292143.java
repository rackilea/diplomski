<html xmlns:c="http://java.sun.com/jstl/core">
...

<c:forEach var="provider" items="#{paymentFormBean.providers}">
    <ui:include src="#{contentFactory.getSpecificForm(provider.formName)}" />
</c:forEach>