public class Dummy<T extends CompareToInt> {

    void method(T k){
        if (k.less(10)){
            // ... do stuff
        }
    }
}