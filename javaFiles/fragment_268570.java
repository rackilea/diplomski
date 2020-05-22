package com.foo;

@Path("/greeting")
public Interface IHelloWorldService {

   @GET
   @Produces("application/xml")
   public Greeting getGreeting();

}

public class HelloWorldService implements IHelloWorldService {
   @override
   public Greeting getGreeting() {
      Greeting g = new Greeting();
      g.message = "Hello World";
      return g;
   }
}