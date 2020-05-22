public class DataView {
    interface NoArgFunction {
        void func();
    }
    interface TwoIntFunction {
        void func(int a, int b);
    }
    static NoArgFunction bind(TwoIntFunction f, int first, int second) {
        return () -> f.func(first, second);
    }

    private static ArrayList<Float> rectData = new ArrayList<Float>();
    private static ArrayList<Float> textData = new ArrayList<Float>();

    DataView(){
        NoArgFunction mybind  = bind(this::functionA, 5, 10);
        NoArgFunction mybind2 = bind(this::functionB, 10, 12);

        iter(mybind);
        iter(mybind2);
    }
    private void iter(NoArgFunction noArg){
        for(Float i : textData){
            noArg.func();
        }
    }
    private void functionA(int a, int b){
        //dostuff
    }
    private void functionB(int a, int b){
        //do other stuff
    }
}