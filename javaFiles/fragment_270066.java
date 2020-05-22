public static void main(String[] args) {
    mytest m = new mytest();
    System.out.println(m.isTheFileIamLookingFor("ArrayList", "java.util.",
            "List"));
}

public boolean isTheFileIamLookingFor(String name, String path,
        String nameOfFatherClass) {
    System.out.println("NAME IS " + name); // prints correct class name
    System.out.println("PATH IS " + path); // prints correct path
    if (!FilenameUtils.getExtension(path).equals("class"))

    {
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            System.out.println(String.format("%s.class", name));
            Class<?> loadedMyClass = classLoader.loadClass(path + name);
            Class<?> c[] = loadedMyClass.getInterfaces();
            if (Arrays.asList(c).contains(
                    Class.forName(path + nameOfFatherClass))) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    return false;

}