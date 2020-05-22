public class Reflection {

    public void sayHello(String theClass){
        //Since Mod classes are in package 'mod', we precede their name accordingly.
        Class aClass = Class.forName("mod." + theClass);
        aClass.getMethod("sayHi").invoke(aClass.newInstance());
    }

    public static void main(String[] args) {
        //Get a list of the compiled classes in the 'mod' folder
        String path = "./bin/mod";
        String fileName;
        File folder = new File(path);
        List<File> fileList = Arrays.asList(folder.listFiles());
        //Iterate through the list of classes to invoke their methods
        Iterator<File> it = fileList.iterator();        
        while(it.hasNext()){
            fileName = it.next().getName();     
            //When invoking the sayHello method, we remove the file extension
            new Reflection().sayHello(fileName.replace(".class", ""));
        }

    }
}