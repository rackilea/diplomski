File myDir = new File("/some/directory/");
ClassLoader loader = null;
try {
    URL url = myDir.toURL();         
    URL[] urls = new URL[]{url};
    loader = new URLClassLoader(urls, null);
} 
catch (MalformedURLException e) 
{
    // oops
}