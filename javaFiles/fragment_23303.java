CodeSource src = MyClass.class.getProtectionDomain().getCodeSource();
if (src != null) {
  URL url = new URL(src.getLocation(), "MyApp.properties");
  ...
} 
else {
  /* Fail... */
}