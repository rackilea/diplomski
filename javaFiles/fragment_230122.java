public class ParameterResult {        
    private int success = 0;
    private int fail = 0;    

    public int getSuccess() {
        return success;
    }    
    public void addSuccess() {
        this.success += 1;
    }    
    public int getFail() {
        return fail;
    }    
    public void addFail() {
        this.fail  += 1;
    }        
}