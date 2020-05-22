public class Bar {
    @Override
    public <T extends Foo> T getBlah() {  
        return this;
    }
}