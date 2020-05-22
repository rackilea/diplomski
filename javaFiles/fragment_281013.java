public void setAuditFields(Audited auditedEntity) {
  auditedEntity.setDateChanged(new Date());
  //...etc...
}

//...
a.setSize(textboxSize.getText());
setAuditFields(a);