public class InvokeClass {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        try {
            String classDerectory = "C:\\classes";
            File folder = new File(classDerectory);
            // read derectory 
            for (final File fileEntry : folder.listFiles()) {
                // URLClassLoader so convert file to url
                URLClassLoader classLoader = new URLClassLoader(new URL[]{fileEntry.toURI().toURL()});
                //get class from loader
                Class<?> clazz = classLoader.loadClass(fileEntry.getName());
                // get new instance
                Object obj=clazz.newInstance();
                // do something with object.......
            }


        } catch (Exception e) {
            // something went wrong..
            e.printStackTrace();
        }

    }
}