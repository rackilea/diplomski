public class CustomValidatorException extends RuntimeException {

    private BindingResult bindingResult;

    public CustomValidatorException(BindingResult bindingResult){
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}