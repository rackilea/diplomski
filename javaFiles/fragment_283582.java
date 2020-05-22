public class MyNotSuperDuperClass {

public MyNotSuperDuperClass(Stage theParentStageOfMyApplication){
     theParentStageOfMyApplication.addEventFilter(MyEventType, new EventHandler<MyEvent>() {
        @Override
        public void handle(MyEvent t) {             
            t.getSource(); //the person who fired the event
            t.getEventTarget();//the person who is receiving the event
        }
    });
}
...