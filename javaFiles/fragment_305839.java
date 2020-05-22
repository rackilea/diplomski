public static void main(String[] args) throws IOException {
    //try with resources guarantees that context will be closed
    try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")){

        //some code...

        //will wait any input in console to avoid immediate context closing
        System.in.read();
    }
}