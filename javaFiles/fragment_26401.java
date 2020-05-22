public class Parent{
private Set<Child> children;

public Set<Child> getChildren(){
    return Collections.unmodifiableSet(children); //no direct access:force clients to use add/remove methods
}

public void addChild(Child child){
    child.setParent(this); 
    children.add(child);
}

public class Child(){
    private Parent parent;
}