abstract class Inner{
    public abstract int getZ();
}

void method(){
    Inner inner = new Inner(){
        private int z =2; // Private fields plz, use get / setters
        public int getZ(){
            return z;
        }
    };