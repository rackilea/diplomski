package com.mycompany.examples.resteasy;

    import javax.ws.rs.core.Application;
    import java.util.HashSet;
    import java.util.Set;

    public class TestApplication extends Application {

        private Set singletons = new HashSet();

        public TestApplication() {
            singletons.add(new Test());
        }

        @Override
        public Set getSingletons() {
            return singletons;
        }

        @Override
        public Set> getClasses() {
            // TODO Auto-generated method stub
            return null;
        }
    }