Class Box<E>{
    private E variable;

    public E get(){
        return variable;
    }

    public void set(E variable){
        this.variable=variable;
    }

    public static void main(String[] args){
        Box<String> example=new Box<String>();
        example.set("test");
        System.out.println(example.get());

        Box<Integer> example2=new Box<Integer>();
        example2.set(1);
        //example2.set("test");will not work because it is types as an Integer
        System.out.println(example2.get()+1);
    }
}