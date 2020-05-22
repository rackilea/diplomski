class Dummy {
    public getData(Info<T> info) {
        List<T> list = info.getDataAsPerInfo();

        List<T> result=new List<>();  

        for(T someType: list){
            // extracting data from someType, lets say this data is 
            // resType (it also of SomeType)
            result.add(resType);  
        }
    }

    public static void main(String args[]){
        Info1 info = new Info1();   // Info1 extends Info<SomeType>
        // adding paramters to info
        new Dummy().getData(info);
    }
}