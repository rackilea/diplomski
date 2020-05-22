public Object rndmFighter(int z)throws Exception
{
    File here = new File("encounter.java");
    String path = here.getAbsolutePath();
    path = path.substring(0,path.lastIndexOf("/"));
    path +="/Zones/"+z+"/enemy";
    File zone = new File(path);
    File[] items = zone.listFiles();
    int r = (int)(Math.random()*(items.length));
    String s = items[r].getName().substring(0,items[r].getName().indexOf("."));
    URL url = zone.toURL();     
    URL[] urls = new URL[]{url};
    ClassLoader cl = new URLClassLoader(urls);
    Class myClass = cl.loadClass(s);
    Object t = myClass.newInstance();
    return t;
}