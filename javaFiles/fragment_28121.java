public class VirtualClass {
    public boolean isPrivate;
    public String className = "Object";
}

ArrayList<VirtualClass> classes = new ArrayList<VirtualClass>(0);

public void addClass(VirtualClass clazz) {
    classes.add(clazz);
}