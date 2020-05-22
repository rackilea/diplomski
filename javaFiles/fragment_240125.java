public class Toto {

    public Toto(){
        // this writes "Toto" in the console if the class is well instanciated
        System.out.println("Toto");
    }

    public static void main(String[] args) {
        try {
            File subfolder = new File("bin");
            URL classUrl = subfolder.toURI().toURL();
            URL[] classUrls = { classUrl };
            URLClassLoader ucl = new URLClassLoader(classUrls);

            for (File f : subfolder.listFiles()) {
                String fileName= f.getName();
                int suffix = fileName.lastIndexOf('.');
                if(f.isDirectory() || suffix==-1){
                    continue;
                }
                String name = fileName.substring(0, suffix);
                try {
                    Class.forName(name, true, ucl).newInstance();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            ucl.close();
        } catch (MalformedURLException e) {
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}