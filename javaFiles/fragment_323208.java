String componentName = "Button";
String classname = "javax.swing.J" + componentName;
Class<?> type = Class.forName(classname);
Class[] argTypes = new Class[]{String.class};
Constructor constructor = type.getConstructor(argTypes);
Object[] parameters = new Object[]{"Button Text"};
JComponent component = (JComponent)constructor.newInstance(parameters);
add( component );