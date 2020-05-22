public class TestException extends RuntimeException { 
    private String message;
    public TestException(){}

    public TestException(String message) {
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ModelAndView asModelAndView() {
        MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
        return new ModelAndView(jsonView, ImmutableMap.of("error", message));
    }