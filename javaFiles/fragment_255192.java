class YourClass{

    List<Boolean> list; 

    YourClass(){
        //constructor 1
    }

    YourClass(String s){
        //constructor 2
    }

    {
        //initialization block, will be executed at start of each
        //constructor (right after its super() call).
        list = new ArrayList<>();
        for (int i=0; i<10; i++)
            list.add(Boolean.FALSE);
    }

}