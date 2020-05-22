// ManagedBean
String userId;

String getUserId(){return this.userId;}
void setUserId(String userId){this.userId = userId;}

// JSF
<h:selectOneMenu value="#{managedBean.userId}"
                        styleClass="inputlabel" id="Vorgesetzter"
                        rendered="#{s.editable}">                            
    <f:selectItems value="#{userBean.userList}" var="us"
                   itemLabel="#{us.surename}, #{us.forename}"
                   itemValue="#{us.userID}" />
</h:selectOneMenu>