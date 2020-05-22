<rich:select listWidth="310" id="userSelect" value="#{departmentBacking.selectedUserId}" 
    disabled="#{departmentBacking.unassignCheckbox}"enableManualInput="true"
    defaultLabel="#{not departmentBacking.unassignCheckbox ? 'start typing a surname...' : 'Uncheck unassign departments first'}">

    <f:selectItem itemValue="0" itemLabel = "SELECT SURNAME" />
    <f:selectItems value="#{departmentBacking.userList}" var="user"
        itemValue="#{user.id}"
        itemLabel="#{user.surname} #{user.name} - #{user.email}" />

</rich:select>