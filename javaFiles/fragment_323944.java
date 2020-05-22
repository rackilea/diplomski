public class C extends A.B {

    public C(String str1, String str2){
        // pass arguments to super constructor
        super(str1, str2);
    }

    @Override
    int deriveCalculatedData(){
        // your stuff
        return -1;
    }
}

// call it from somewhere with arguments
C c = new C(str1, str2);