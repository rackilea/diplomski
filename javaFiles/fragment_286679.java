//Get ID of the Document 
        StringBuffer propertyNames = new StringBuffer();
        propertyNames.append(PropertyNames.ID);
        propertyNames.append(" ");
        propertyNames.append(PropertyNames.PATH_NAME);

        PropertyFilter pf=new  PropertyFilter();

        FilterElement felement= new FilterElement(Integer.valueOf(0),Long.valueOf(0),Boolean.TRUE,propertyNames.toString(),Integer.valueOf(0));
        pf.addIncludeProperty(felement);

        Document document = Factory.Document.fetchInstance(os, ruta, pf );

        idDocument = document.get_Id().toString();