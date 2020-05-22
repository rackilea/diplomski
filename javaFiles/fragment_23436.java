public interface Procedure {
    void act();
}
public void executeCommand(Procedure proc){
    proc.act();
}
//...
// pass a method using lambda expression:
    executeCommand(()->{system.out.println("Hello world"});

//pass a method using traditional way (anonymous class)
    executeCommand(new Procedure() {

        public void act() {
            system.out.println("Hello world");
        }
    });