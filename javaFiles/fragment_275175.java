@Mojo(name = "hellomojo")
    public class HelloMojo extends AbstractMojo {    

     private SomeService service;  

    public HelloMojo(){
       this(new SomeService())      
    }   

    public HelloMojo(SomeService someService){
       this.service=someService;
    }   

     @Override
     public void execute() throws MojoExecutionException {     
        service.doSomething
     }             
    }