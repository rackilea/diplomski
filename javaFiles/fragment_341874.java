if (args[1].equalsIgnoreCase("exe"))   // it might be args[0], I can't remember
{
  String className = "java.assignments." + args[2];
  Object o = Class.forName(className);
  Main   mainMethodClass = (Main)o;
  o.main();
}