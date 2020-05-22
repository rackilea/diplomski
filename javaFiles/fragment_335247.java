QPersonAttribute attribute = QPersonAttribute.personAttribute;
new JPASubQuery().from(attribute)
    .where(attribute.in(person.attributes),
           attribute.attributeName().name.toLowerCase().eq("eye color"),
           attribute.attributeValue.toLowerCase().eq("blue"))
     .exists()