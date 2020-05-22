public class B implements Ib {

    public function makeCopy():Ia {
        return this;
    }

    public function B() {
        trace(makeCopy() is Ia);  //true
        trace(makeCopy() is Ib);  //true
        trace(makeCopy() is B);   //true
    }
}