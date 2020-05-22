//SymbolicName of the property we will search for.
    String strSearchName = PropertyNames.DATE_LAST_MODIFIED;
    //Document (or other object) that we will use to get classDescription.
    Document document = (Document) arg0; 

    PropertyDescription objPropDesc = null;
    PropertyDescriptionList pdl = document.get_ClassDescription().get_PropertyDescriptions();
    Iterator<?> iter = pdl.iterator();
    while (iter.hasNext())
    {                                               
        objPropDesc = (PropertyDescription) iter.next();                      

       // Get SymbolicName property from the property cache
       String strPropDescSymbolicName = objPropDesc.get_SymbolicName();

       if (strPropDescSymbolicName.equalsIgnoreCase(strSearchName))
       {
          // PropertyDescription object found
          System.out.println("Property description selected: " + strPropDescSymbolicName);
          System.out.println(objPropDesc);

          TypeID type = objPropDesc.get_DataType();
          System.out.println(type.toString());
          break;
       }
    }