List<Class> classList = ...l
Map<Class,Node> classMap = ... a map from all your classes to nodes made from them;
Node rootNode = null;

for(Class c : classList){
    Node parentNode = classMap.get(c.getSuperclass());
    if(parentNode != null)
        parentNode.children.add(classMap.get(c));
    else
        rootNode = classMap.get(c);
}