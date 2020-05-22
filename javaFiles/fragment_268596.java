public static void main(String args[]){
    //Your customized mapper
    ModelMapper modelMapper = new MyCustomizedMapper();

    MySource src = null;
    MyTarget trg = modelMapper.map(src, MyTarget.class); //trg = null
    System.out.println(trg);
}