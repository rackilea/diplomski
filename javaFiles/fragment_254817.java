<?xml version='1.0' encoding='UTF-8'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1" xmlns:f="http://java.sun.com/jsf/core"
          xmlns:af="http://xmlns.oracle.com/adf/faces/rich">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <f:view>
        <af:document title="Page.jspx" id="d1">
            <af:form id="f1">
                <af:panelStretchLayout id="psl1">
                    <f:facet name="center">
                            <af:panelAccordion id="pa1" discloseNone="false" partialTriggers="soc1" discloseMany="true" reorder="enable">
                                <af:iterator value="#{college.departments}" var="department">
                                    <af:showDetailItem text="#{department.departmentName}" id="sdi1">
                                        <af:iterator value="#{department.employees}" var="employee">
                                            <af:showDetailHeader text="#{employee.name}" disclosed="false" id="sdh1">
                                                <af:outputText value="#{employee.info}" id="ot1"/>
                                            </af:showDetailHeader>
                                        </af:iterator>
                                    </af:showDetailItem>
                                </af:iterator>
                            </af:panelAccordion>    
                    </f:facet>
                    <f:facet name="top">
                        <af:selectOneChoice label="Department" value="#{college.selectedDepartment}" id="soc1" unselectedLabel="" autoSubmit="true"
                                            valueChangeListener="#{college.departmentDropDrownValueChangeListener}" immediate="true">
                            <f:selectItems value="#{college.departmentDropDownMenu}" id="si1"/>
                        </af:selectOneChoice>
                    </f:facet>
                </af:panelStretchLayout>
            </af:form>
        </af:document>
    </f:view>
</jsp:root>