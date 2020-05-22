class GenericArrayTest<T>{
    T[] array1; // this array will be created by (T[])new Object[size];
    Object[] array2; // this will be created by new Object[size]
    T[] array3; // and this as (T[])Array.newInstance(type, size);

    GenericArrayTest(Class<T> type, int size){
        array1=(T[])new Object[size];
        array2=new Object[size];
        array3=(T[])Array.newInstance(type, size);
    }

    void put1(T data, int index){ array1[index]=data; }
    void put2(T data, int index){ array2[index]=data; }
    void put3(T data, int index){ array3[index]=data; }

    T get1(int index){ return array1[index]; }
    T get2(int index){ return (T)array2[index]; }
    T get3(int index){ return array3[index]; }

    void showArraysRow(int index){
        System.out.println(get1(index)+" "+get2(index)+" "+get3(index));
    }

    //TEST
    public static void main(String[] args) {
        //we will put
        GenericArrayTest<Integer> k=new GenericArrayTest<Integer>(Integer.class,10);
        k.put1(123, 0);
        k.put2(123, 0);
        k.put3(123, 0);

        k.showArraysRow(0);

        //I CREATE RAW TYPE REFERENCE - no generic control anymore
        GenericArrayTest k2=k;
        k2.put1("data1", 0);
        k2.put2("data2", 0);
//      k2.put3("data3", 0);//<- this would throw ArrayStoreException - wrong data type

        k2.showArraysRow(0);
    }
}