try
{
    String componentName = "Button";
    String classname = "javax.swing.J" + componentName;
    JComponent component = (JComponent)Class.forName(classname).newInstance();
    // add component to your panel

}
catch(Exception e) { System.out.println(e); }