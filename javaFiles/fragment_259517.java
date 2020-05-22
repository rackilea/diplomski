public enum Sample {
    A(AClass.getAValue()) {
        @Override public int getVal(int x) {
            return AClass.getAValue(x);
        }
    },
    B(BClass.getAValue()) {
        @Override public int getVal(int x) {
            return BClass.getBValue(x);
        }
    },
    C(CClass.getAValue()) {
        @Override public int getVal(int x) {
            return CClass.getCValue(x);
        }
    };

    private int _value; 

    private Sample(int _val){
       this._value = _val; 
    }

    public int getVal(){
        return _value; 
    }

    public abstract int getVal(int x);
}