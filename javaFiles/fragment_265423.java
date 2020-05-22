public static class TNativeFoo extends com.sun.jna.Structure {

       public TNativeFoo (){ }
       public TNativeFoo(com.sun.jna.Pointer pointer, int offset) {
            super(pointer.share(offset));
            read();
        }
        public TNativeFoo(TNativeFoo struct) {
            super(struct.getPointer());
            read();
        }
        // NOTE: use Java conventions for field names, please
        private Pointer buffer;
        public Pointer data = new Memory(Pointer.SIZE);
        public NativeLong items;
        public Pointer irrelevantStringArray = new Memory(Pointer.SIZE);
        public NativeLong stringsCounts = new NativeLong(0);

        public double[] getData() { 
            Pointer p = data.getPointer(0);
            if (p == null) return null;
            return p.getDoubleArray(items.intValue());  
        }
        public void setData(double[] data) {
            Pointer p = this.data.getPointer(0);
            if (p == null) {
               p = buffer = new Memory(data.length * 8);    
               this.data.setPointer(0, buffer);
            }
            p.write(0, data, 0, data.length);
        }
    }

    NativeLong FooInterface(TNativeFoo input, TNativeFoo output);
}