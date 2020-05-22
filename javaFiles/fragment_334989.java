class Nesting {
    interface Inner{
        int getZ();
    }
    void method(){
        Inner inner = new Inner(){
            private int z =2;
            public int getZ(){
                return z;
            }
            private int anotherInnerMethod(){
                // Can access non-interface items as it is part of the anon subclass
                return z * z;
            }
        };
        System.out.println(inner);
        // Access getZ() through the interface
        System.out.println(inner.getZ());
    }
    // Because this method is in class Nesting, it may still access Inner
    public static void main(String args[]){
        Nesting ne = new Nesting();
        ne.method();
        Inner inner = new Inner(){
            private int z =1;
            public int getZ(){
                return z;
            }
        };
        System.out.println(inner.getZ());
        ne.method();
    }
}