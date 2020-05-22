public class TargetAction extends ActionSupport implements Validateable{

    private File file;
    private String fileContentType;
    private String fileFileName;
    /* Getters and setters */

    public String execute() {
        return SUCCESS;
    }

    public void validate() {
        if (file==null){
            addFieldError("file","File is mandatory !! Please Retry");
        }
    }    
    /* when fieldErrors are added, INPUT result will be returned */ 

}