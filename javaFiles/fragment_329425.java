public class MyListener {

    @PostLoad
    private void saveState(MyClass myClass){
         myClass.saveState(SerializationUtils.clone(myClass)); // from apache commons-lang
    }

}

public class MyClass implements Serializable {

     @Transient
     private transient MyClass savedState;

     void saveState(MyClass savedState){
        this.savedState = savedState;
     }

}