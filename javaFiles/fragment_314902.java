// Get the ClassDescription
String strSymbolicName = "myClassName";
ClassDescription objClassDesc = Factory.ClassDescription.fetchInstance(myObjStore, strSymbolicName, null);

// find the PropertyDescription     
PropertyDescription pds = null;
PropertyDescriptionList pdl = objClassDesc.get_PropertyDescriptions()‌​;
Iterator<?> itr = pdl.iterator();
while(itr.hasNext()){ 
    pds = (PropertyDescription) itr.next();
    System.out.println("Symbolic Name is "+pds.get_SymbolicName()+" DataType is "+pds.get_DataType().toString()); 
}

// You can now use it in a loop of several documents if you wish.
...