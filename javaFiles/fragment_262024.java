Query query = pm.newQuery(User.class, "userAttributeCollection.contains(att) & att.value == :val & definition.attributeName == :name");
    query.declareVariables("ObjectAttribute att; ObjectAttributeDefinition definition");
    query.declareImports("import com.us.orm.general.models.ObjectAttributeDefinition; import com.us.orm.general.models.ObjectAttribute");

    query.setResultClass(User.class);

    rval =  (List<User>) query.execute(myAtt.getValue(), name.toString());