public class Child extends Base {
    private ChildObjectDependency child_object_dependency;

    public void myMethod() {
        BaseObjectDependency obj = getBase_object_dependency();
        //do something here
    }

    public ChildObjectDependency getChild_object_dependency() {
        return child_object_dependency;
    }
}