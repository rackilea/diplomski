class Immutable {
    private int i;
    public static Immutable create(int i){
        return new Immutable(i);
    }
    private Immutable(int i){this.i = i;}
    public int getI(){return i;}
}