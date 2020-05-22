public Parent addChild(Parent parent) {
Child child = new Child();
child.setParent(parent);
parent.getChildren().add(child);

parent=entityManager.merge(parent);
System.out.println("addChild : parent.id = " + parent.getId());

// The following give me a null id
System.out.println("addChild : child.id = " + parent.getChildren().iterator().next().getId());

System.out.println("addChild : child.id = " + child.getId());'
return parent;