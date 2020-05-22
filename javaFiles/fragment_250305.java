<span>
  <mysecurity:secure_link id='<%="editButton_"+commentUUID%>' entitlement="" 
      actionOnClick="javascript:editComment(this.id.split('_')[1]);return false;"
      isSurroundedByBrackets="true" enableTitle="" disableLink="<%=disableLink%>">
      <span style="color:#0033BB; font:8pt arial;">
         <bean:message key="button.edit" />
      </span>
  </mysecurity:secure_link>
</span>