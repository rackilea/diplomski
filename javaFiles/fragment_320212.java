<html xmlns="http://www.w3.org/1999/xhtml"   
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      >
...
    <h:inputText id="date" value="#{yourBean.dateField}" 
                 size="20" required="true">

        <f:convertDateTime pattern="dd-MM-yyyy" />
    </h:inputText>
...
</html>