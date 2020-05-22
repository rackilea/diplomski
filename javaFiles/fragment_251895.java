interface Wrapper{}

class StringWrapper extends Wrapper{
    String s;

    public StringWrapper(String s){
        this.s = s;
    }
}

class IntWrapper extends Wrapper{
    String i;

    public StringWrapper(Integer i){
        this.i = i;
    }
}