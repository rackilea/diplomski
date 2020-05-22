public class A {

        private String a1;
        private String a2;
        private String a3;

        public A (String a1, String a2, String a3){
            this.a1 = a1;
            this.a2 = a2;
            this.a3 = a3;
        }

        ...
    }

    public class B {

         private String b1;
         private String b2;
         private String b3;

        public B (String b1, String b2, String b3){

            this.b1 = b1;
            this.b2 = b2;
            this.b3 = b3;
        }

        ...
    }

    public class C {
        private A a;
        private B b;


        public B (A a, B b){
            this.a  = a;
            this.b  = b;
        }

        ...
    }