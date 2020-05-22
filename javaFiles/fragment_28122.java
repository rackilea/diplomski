// in actionPerformed

ClassObject.VirtualClass clazz = new ClassObject.VirtualClass();

clazz.isPrivate = rbPrivate.isSelected();
clazz.className = tfClassName.getText();

classObject.addClass(clazz);