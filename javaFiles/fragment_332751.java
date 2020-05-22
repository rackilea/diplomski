public class GameObject extends SomeObject {
    public GameObject(){
        // implicitly calls super() which will call objectStart() which will call start()
    }
    @Override
    public void start(){
    }
}