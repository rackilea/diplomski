// Copy properties from someObject to myTargetObject
Map attributes = BeanUtils.describe(someObject);
SomeBean myTargetObject = new SomeBean();

for(String propertyName : attributes.keySet()){
  System.out.println("Value for attribute " + propertyName + " is " + attributes.get(propertyName));

  // Updates target object
  BeanUtils.setProperty(myTargetObject, propertyName, attributes.get(propertyName));
}