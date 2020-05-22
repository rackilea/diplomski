public class SomeClass{
    private Set<String> blah;

    public SomeClass(){
        // do stuff
    }

    public Set<String> getBlah(){
        return blah;
    }

    private Object readResolve() {
        if(blah == null){
            blah = new HashSet<String>();
        }
        return this;
    }
}