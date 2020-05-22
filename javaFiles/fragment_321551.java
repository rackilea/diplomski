@EntityListeners(class=MyEntityListeners.class)
public class ClassB extends ClassA {
  .....
}

public class MyEntityListeners {
    @PrePersist
    public void onPrePersist(Object entity) {
        //logic with entity (check the class of the entity or you can use `ClassA` instead of `Object`)
    }
}