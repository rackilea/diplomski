public class MyClass implements Serializable {

     @Transient
     private transient MyClass savedState;

     @PostLoad
     private void saveState(){
        this.savedState = SerializationUtils.clone(this); // from apache commons-lang
     }

}