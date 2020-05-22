class TheConcrete {
    static final ToIntFunction<TheConcrete> GET_A=new ToIntFunction<TheConcrete>() {
        public int applyAsInt(TheConcrete instance) {
            return instance.getA();
        }
    };
    static final ToIntFunction<TheConcrete> GET_B=new ToIntFunction<TheConcrete>() {
        public int applyAsInt(TheConcrete instance) {
            return instance.getB();
        }
    };
 … rest as in your original class