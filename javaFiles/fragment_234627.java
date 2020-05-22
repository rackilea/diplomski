class Child<T extends TreeData>{
    public void print(T data){
        String a = data.getSixString();
        //should work now since T defines getSixString()
    }
}