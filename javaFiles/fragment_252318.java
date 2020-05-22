try {
  try {
    b = loadClassData(className);
  }
  catch(FileNotFoundException fnf) {
    return super.findClass(className);
  }
  Class c = defineClass(className, b, 0, b.length);
  if(c != null)
    return c;
  return super.findClass(className);
} catch (IOException e) {
  e.printStackTrace();
}
return null;