<ui:composition xmlns="http://www.w3.org/1999/xhtml"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:rich="http://richfaces.org/rich"
    xmlns:a4j="http://richfaces.org/a4j" 
    xmlns:o="http://omnifaces.org/ui"
    xmlns:of="http://omnifaces.org/functions"
    xmlns:ui="http://java.sun.com/jsf/facelets">
    <o:methodParam name="methodParam" value="#{actionBeanMethod}" />

    <a4j:commandLink value="delete" onclick="#{rich:component('confirmation')}.show();return false" />

    <h:commandButton value="direct" action="#{methodParam}" />

    <a4j:jsFunction name="submit" action="#{methodParam}" render="#{render}" />

    <rich:popupPanel id="confirmation" width="250" height="150">
        <f:facet name="header">Confirmation</f:facet>
        <h:panelGrid>

            <h:panelGrid columns="1">
                <h:outputText value="Are you sure?" style="FONT-SIZE: large;" />
            </h:panelGrid>

            <h:panelGroup>
                <input type="button" value="OK" onclick="#{rich:component('confirmation')}.hide(); submit(); return false" />
                <input type="button" value="Cancel" onclick="#{rich:component('confirmation')}.hide(); return false" />
            </h:panelGroup>
        </h:panelGrid>
    </rich:popupPanel>

</ui:composition>