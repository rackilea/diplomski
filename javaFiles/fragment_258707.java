@Entity
 public class SomeEntity{

        @Transient
        private SomeEntity previousState;

        @PostLoad
        private void storeState(){
          previousState = new SomeEntity();
          previousState.setPassword(this.getPassword());  
        }

        @PreUpdate
        private void doBeforeUpdate(){
            if(!previousState.getPassword().equals(this.getPassword()){
                //update time.  
            }
        }
    }