public abstract class TestAdapter implements Test {

    private AbstractPojo myPojo;

    protected void doBeforeStart(){
        // do something which you always want to happen
        beforeStart();
    } 
    protected void doStart() {
        start();
    }
    protected void doEnd() {
        end();
    }

    // your empty implementations of Test here

    // getter and setter for myPojo
}