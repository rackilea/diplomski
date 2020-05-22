class PointerArray extends Memory {                      
        private final Pointer[] original;                                                           
        public PointerArray(Pointer[] arg) {                                                        
            super(Pointer.SIZE * (arg.length+1));                                                   
            this.original = arg;                                                                    
            for (int i=0;i < arg.length;i++) {                                                      
                setPointer(i*Pointer.SIZE, arg[i]);                                                 
            }                                                                                       
            setPointer(Pointer.SIZE*arg.length, null);                                              
        }                                                                                           
    }
}