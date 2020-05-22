@ManagedBean
public class TestBean {

    private String errorMessage = null;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void submitForm(){
        // .....
        //if(error){
            this.errorMessage = "My error Message";
        //} 
    }
}