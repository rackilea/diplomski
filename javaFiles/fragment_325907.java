public static void main(String[] args) {
        StaticNestedClass n1 = new StaticNestedClass("n1"); //  1st object created 
        StaticNestedClass n2 = new StaticNestedClass("n2");  // 2nd object created 
        Collection list = new ArrayList(); // 3rd object
        list.add(n1); // n1 has a strong reference, so n1 is not ready for GC.
        StaticNestedClass[] arr = new StaticNestedClass[2];// 4th object created
        arr[0] = n2; //n2 has strong reference, so, even n2 is not ready.
        n2 = n1; // both n1 and n2 point to same object as that of n1. but arr[0] still references n2. 
        clear(arr); // you are passing references by value. SO, this has absolutely no effect on GC.
        n1 = null;// Object pointed to by n1 is still being referenced by n2
        n2 = null; //Object pointed to by n1 has a reference in the list.
        System.gc();
       //the rest of the code
    }


    private static void clear(StaticNestedClass[] arr) {
        arr = null;
    }