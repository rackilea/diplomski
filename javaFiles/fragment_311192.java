public class VaadinApplication {

    private String code = null; // <-- Instance variable

    protected void init(VaadinRequest request) {
        main();
        String code = request.getParameter("code");
        if (code != null){
            this.code = code; // <-- store code here
            System.out.println("Code: " + code);
            next();
    }

    protected void otherMethod() {
        this.code; // <-- Get code here and use it
        //...
    }
}