@SuppressWarnings("unchecked")
public <T extends IObject> List<T> getObject(){
  ArrayList<T> objects = (ArrayList<T>) new ArrayList<ConcreteObject>();
  objects.add(new ConcreteObject());
  return objects;
}

…
List<OtherConcreteObject> objects = getObject(); // Works.
OtherConcreteObject obj = OtherConcreteObject.get(0); // Throws CCE.