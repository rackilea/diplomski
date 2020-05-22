//name of variable that needs to be expanded
        String varName ="DERBY_JDBC_DRIVER_PATH";
        //create a configservice proxy
        configService = new ConfigServiceProxy(adminClient);
        //create a session
        Session session = new Session();
        //ObjectName for the variables.xml
        ObjectName varMapObjName = ConfigServiceHelper.createObjectName(null, "VariableMap", null);
        //query all variables.xml under cell.scope is null
        ObjectName[] variableMaps = configService.queryConfigObjects(session, null, varMapObjName, null);

        for (int i = 0; i < variableMaps.length; i++) {
            ObjectName varMap = (ObjectName) variableMaps[i];
            //retrieve each variable entry
            AttributeList varEntries = configService.getAttributes(session, varMap, new String[]{"entries"}, false);
            List entryList = (List) ConfigServiceHelper.getAttributeValue(varEntries, "entries");
            //Iterate through each entry and get the value for the specified variable(symbolicName) name.
            for (int j = 0; j < entryList.size(); j++) {
                ObjectName varObj = (ObjectName)entryList.get(j);
                String symbolicName=  (String)configService.getAttribute(session, varObj, "symbolicName");
                String value = null;
                if (symbolicName.equals(varName)){
                    value= (String)configService.getAttribute(session, varObj, "value");
                    System.out.println(symbolicName+"="+value);
                }
            }
        }