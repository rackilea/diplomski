public class ParentObject{

    public ParentObject(Long age, ChildObject childObject) {
        this.age = age;
        this.childObject = childObject;

        childObject.setParentObject(this);
    }

    public void setChildObject(ChildObject childObject) {
        this.childObject = childObject;
        childObject.setParentObject(this);
    }
}