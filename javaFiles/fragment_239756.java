package com.mycompany.examples.resteasy;

    import javax.ws.rs.GET;
    import javax.ws.rs.Path;

    @Path("/")
    public class Test {
        public Test() {
        }

        @GET
        @Path("/test")
        public String test() {
            return "Hello RESTFul";
        }

    }